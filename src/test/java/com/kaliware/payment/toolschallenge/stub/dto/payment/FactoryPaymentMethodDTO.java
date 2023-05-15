package com.kaliware.payment.toolschallenge.stub.dto.payment;

import com.kaliware.payment.toolschallenge.dto.PaymentMethodDTO;

public class FactoryPaymentMethodDTO{

  public static PaymentMethodDTO craateRequestPaymentMethodDTO(){

    PaymentMethodDTO dto = new PaymentMethodDTO();
    dto.setType("AVISTA");
    dto.setInstallments("1");

    return dto;
  }
}
