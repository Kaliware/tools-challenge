package com.kaliware.payment.toolschallenge.services.payments;

import com.kaliware.payment.toolschallenge.dto.DescriptionDTO;
import com.kaliware.payment.toolschallenge.dto.PaymentDTO;
import com.kaliware.payment.toolschallenge.dto.PaymentMethodDTO;
import com.kaliware.payment.toolschallenge.dto.TransactionDTO;
import com.kaliware.payment.toolschallenge.enums.EnmPaymentStatus;
import com.kaliware.payment.toolschallenge.services.exceptions.InvalidPaymentException;
import com.kaliware.payment.toolschallenge.services.exceptions.OperationAlreadyPerformedException;
import com.kaliware.payment.toolschallenge.services.exceptions.ResourceNotFoundException;
import com.kaliware.payment.toolschallenge.utils.BigDecimalUtils;
import com.kaliware.payment.toolschallenge.utils.NumberUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kaliware.payment.toolschallenge.enums.EnmPaymentMethod.*;
import static com.kaliware.payment.toolschallenge.enums.EnmPaymentStatus.*;
import static com.kaliware.payment.toolschallenge.utils.AuthorizationCodeGenerator.generateAuthorizationCode;
import static com.kaliware.payment.toolschallenge.utils.CreditCardUtils.isValidCreditCardNumber;
import static com.kaliware.payment.toolschallenge.utils.DateTimeUtils.validateDateTime;
import static com.kaliware.payment.toolschallenge.utils.NSUGenerator.generateNSU;

@Service
public class PaymentService implements IPaymentService{

  private static final Map<String, PaymentDTO> payments = new HashMap<>();

  @Override
  public PaymentDTO payment(PaymentDTO paymentDto){
    String transactionId = paymentDto.getTransaction().getId();
    if(payments.containsKey(transactionId)){
      throw new OperationAlreadyPerformedException("Pagamento já realizado! ID: " + transactionId);
    }

    TransactionDTO transactionDto = paymentDto.getTransaction();
    PaymentMethodDTO paymentMethodDto = transactionDto.getPaymentMethod();
    DescriptionDTO descriptionDTO = transactionDto.getDescription();

    String datetime = descriptionDTO.getDatetime();
    String paymentType = paymentMethodDto.getType();
    long paymentInstallments = NumberUtils.extractNumbers(paymentMethodDto.getInstallments());

    validatePayment(paymentType, paymentInstallments, datetime);

    BigDecimal monetaryValue = BigDecimalUtils.BigDecimalConverter(descriptionDTO.getValue());
    descriptionDTO.setValue(monetaryValue.toString());
    generateAuthorizationAndNSU(transactionDto);
    setDescriptionStatus(transactionDto);

    payments.put(transactionId, paymentDto);
    return paymentDto;
  }

  private void validatePayment(String paymentType, long paymentInstallments, String datetime){
    if(paymentType.equalsIgnoreCase(AVISTA.getName()) && paymentInstallments != 1){
      throw new InvalidPaymentException("O pagamento à vista não pode ser parcelado.");
    }

    if(paymentInstallments < 1){
      throw new InvalidPaymentException("O pagamento deve ter parcelas iguais ou superiores a 1.");
    }
    if(!validateDateTime(datetime)){
      throw new InvalidPaymentException("dataHora inválida!");
    }

    if(!(paymentType.equalsIgnoreCase(AVISTA.getName()) || paymentType.equalsIgnoreCase(PARCELADO_EMISSOR.getName()) || paymentType.equalsIgnoreCase(PARCELADO_LOJA.getName()))){
      throw new InvalidPaymentException("Tipo de pagamento Inválido! valor: " + paymentType);
    }


  }

  private void generateAuthorizationAndNSU(TransactionDTO transactionDto){
    transactionDto.getDescription().setAuthorizationCode(generateAuthorizationCode());
    transactionDto.getDescription().setNsu(generateNSU());
  }

  private void setDescriptionStatus(TransactionDTO transactionDto){
    EnmPaymentStatus status = isValidCreditCardNumber(transactionDto.getCard()) ? AUTORIZADO : NEGADO;
    transactionDto.getDescription().setStatus(status);
  }


  @Override
  public PaymentDTO refund(String id){
    if(!payments.containsKey(id)){
      throw new ResourceNotFoundException("Transação não encontrada!");
    }
    PaymentDTO dto = payments.get(id);

    if(dto.getTransaction().getDescription().getStatus().equals(NEGADO)){
      throw new InvalidPaymentException("Não é possível realizar o estorno para uma transação negada!");
    }
    if(dto.getTransaction().getDescription().getStatus().equals(CANCELADO)){
      throw new OperationAlreadyPerformedException("Estorno já realizado! ID: " + id);
    }
    dto.getTransaction().getDescription().setStatus(EnmPaymentStatus.CANCELADO);
    payments.put(id, dto);
    return dto;
  }

  @Override
  public PaymentDTO findById(String id){
    if(!payments.containsKey(id)){
      throw new ResourceNotFoundException("Transação não encontrada!");
    }
    return payments.get(id);
  }

  @Override
  public List<PaymentDTO> findAll(){
    if(payments.isEmpty()){
      throw new ResourceNotFoundException("Nenhuma transação realizada!");
    }
    return payments.values().stream().toList();
  }

}
