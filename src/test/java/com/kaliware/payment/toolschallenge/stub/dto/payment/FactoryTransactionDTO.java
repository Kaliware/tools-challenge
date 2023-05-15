package com.kaliware.payment.toolschallenge.stub.dto.payment;

import com.kaliware.payment.toolschallenge.dto.TransactionDTO;

import static com.kaliware.payment.toolschallenge.stub.dto.payment.FactoryDescriptionDTO.craateRequestDescriptionDTO;
import static com.kaliware.payment.toolschallenge.stub.dto.payment.FactoryPaymentMethodDTO.craateRequestPaymentMethodDTO;

public class FactoryTransactionDTO{

  public static TransactionDTO craateRequestTransactionDTO(){

    TransactionDTO dto = new TransactionDTO();
    dto.setCard("55190832202274767");
    dto.setId("10002356890070");
    dto.setDescription(craateRequestDescriptionDTO());
    dto.setPaymentMethod(craateRequestPaymentMethodDTO());

    return dto;
  }
}
