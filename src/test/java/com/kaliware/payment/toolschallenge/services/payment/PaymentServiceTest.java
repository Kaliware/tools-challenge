package com.kaliware.payment.toolschallenge.services.payment;

import com.kaliware.payment.toolschallenge.dto.PaymentDTO;
import com.kaliware.payment.toolschallenge.enums.EnmPaymentMethod;
import com.kaliware.payment.toolschallenge.enums.EnmPaymentStatus;
import com.kaliware.payment.toolschallenge.services.exceptions.InvalidPaymentException;
import com.kaliware.payment.toolschallenge.services.exceptions.OperationAlreadyPerformedException;
import com.kaliware.payment.toolschallenge.services.exceptions.ResourceNotFoundException;
import com.kaliware.payment.toolschallenge.services.payments.PaymentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.kaliware.payment.toolschallenge.stub.dto.payment.FactoryPaymentDTO.craateRequestPaymentDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DisplayName("PaymentService Test")
public class PaymentServiceTest{

  @InjectMocks
  private PaymentService service;

  private PaymentDTO dto;

  @BeforeEach
  void setUp() throws Exception{
    dto = craateRequestPaymentDTO();
  }

  @Nested
  @DisplayName("payment Method")
  class PaymentMethod{
    @Test
    @DisplayName("should Perform Payment Successfully")
    public void shouldPerformPaymentSuccessfully(){
      dto.getTransaction().setId("6");
      PaymentDTO result = service.payment(dto);

      assertNotNull(result);
      assertEquals(EnmPaymentStatus.AUTORIZADO, result.getTransaction().getDescription().getStatus());
    }

    @Test
    @DisplayName("Should throw InvalidPaymentException when installments is zero")
    public void shouldThrowExceptionWhenNegativeValueInInstallments(){
      dto.getTransaction().setId("1");
      dto.getTransaction().getPaymentMethod().setType(EnmPaymentMethod.PARCELADO_LOJA.getName());
      dto.getTransaction().getPaymentMethod().setInstallments("0");
      Assertions.assertThrows(InvalidPaymentException.class, () -> {
        service.payment(dto);
      });
    }

    @Test
    @DisplayName("should Throw Exception When Invalid Payment Method Type")
    public void shouldThrowExceptionWhenInvalidPaymentMethodType(){
      dto.getTransaction().setId("3");
      dto.getTransaction().getPaymentMethod().setType("AVISTA PARCELADO");
      Assertions.assertThrows(InvalidPaymentException.class, () -> {
        service.payment(dto);
      });
    }

    @Test
    @DisplayName("should Throw Exception When Transaction Already Authorized")
    public void shouldThrowExceptionWhenTransactionAlreadyAuthorized(){
      dto.getTransaction().setId("5");
      service.payment(dto);
      Assertions.assertThrows(OperationAlreadyPerformedException.class, () -> {
        service.payment(dto);
      });
    }

    @Test
    @DisplayName("should Throw Exception When Avista Payment Is Not Single Installment")
    public void shouldThrowExceptionWhenAvistaPaymentIsNotSingleInstallment(){
      dto.getTransaction().setId("2");
      dto.getTransaction().getPaymentMethod().setType(EnmPaymentMethod.AVISTA.getName());
      dto.getTransaction().getPaymentMethod().setInstallments("2");

      InvalidPaymentException exception = Assertions.assertThrows(InvalidPaymentException.class, () -> {
        service.payment(dto);
      });
      assertEquals("O pagamento à vista não pode ser parcelado.", exception.getMessage());
    }

    @Test
    @DisplayName("should Throw Exception When Invalid DateTime")
    public void shouldThrowExceptionWhenInvalidDateTime(){
      dto.getTransaction().setId("4");
      dto.getTransaction().getDescription().setDatetime("2023-05-35T12:00:00Z");

      InvalidPaymentException exception = Assertions.assertThrows(InvalidPaymentException.class, () -> {
        service.payment(dto);
      });
      assertEquals("dataHora inválida!", exception.getMessage());
    }
  }

  @Nested
  @DisplayName("refund Method")
  class RefundMethod{

    @Test
    @DisplayName("should Refund Payment Successfully")
    public void shouldRefundPaymentSuccessfully(){
      PaymentDTO response = service.payment(dto);
      response.getTransaction().getDescription().setStatus(EnmPaymentStatus.AUTORIZADO);

      PaymentDTO result = service.refund(response.getTransaction().getId());

      assertNotNull(result);
      assertEquals(EnmPaymentStatus.CANCELADO, result.getTransaction().getDescription().getStatus());
    }

    @Test
    @DisplayName("should Throw ResourceNotFoundException When Transaction Not Found")
    public void shouldThrowResourceNotFoundExceptionWhenTransactionNotFound(){
      String nonExistId = "123456789";

      ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
        service.refund(nonExistId);
      });
      assertEquals("Transação não encontrada!", exception.getMessage());
    }

    @Test
    @DisplayName("should Throw InvalidPaymentException When Transaction Status is NEGADO")
    public void shouldThrowInvalidPaymentExceptionWhenTransactionStatusIsNegado(){
      dto.getTransaction().setId("11111111111");
      PaymentDTO response = service.payment(dto);

      response.getTransaction().getDescription().setStatus(EnmPaymentStatus.NEGADO);

      InvalidPaymentException exception = Assertions.assertThrows(InvalidPaymentException.class, () -> {
        service.refund(response.getTransaction().getId());
      });
      assertEquals("Não é possível realizar o estorno para uma transação negada!", exception.getMessage());
    }

    @Test
    @DisplayName("should Throw OperationAlreadyPerformedException When Refund Already Performed")
    public void shouldThrowOperationAlreadyPerformedExceptionWhenRefundAlreadyPerformed(){
      dto.getTransaction().setId("111111111111");
      PaymentDTO response = service.payment(dto);

      service.refund(response.getTransaction().getId());
      OperationAlreadyPerformedException exception = Assertions.assertThrows(OperationAlreadyPerformedException.class, () -> {
        service.refund(response.getTransaction().getId());
      });
      assertEquals("Estorno já realizado! ID: 111111111111", exception.getMessage());
    }
  }

}
