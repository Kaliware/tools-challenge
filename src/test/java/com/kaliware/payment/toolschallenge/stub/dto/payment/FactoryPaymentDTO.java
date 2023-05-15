package com.kaliware.payment.toolschallenge.stub.dto.payment;

import com.kaliware.payment.toolschallenge.dto.PaymentDTO;

import static com.kaliware.payment.toolschallenge.stub.dto.payment.FactoryTransactionDTO.craateRequestTransactionDTO;

public class FactoryPaymentDTO{

  public static PaymentDTO craateRequestPaymentDTO(){
    PaymentDTO dto = new PaymentDTO();
    dto.setTransaction(craateRequestTransactionDTO());
    return dto;
  }
}
