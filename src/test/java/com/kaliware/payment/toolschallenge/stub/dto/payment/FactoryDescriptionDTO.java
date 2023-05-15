package com.kaliware.payment.toolschallenge.stub.dto.payment;

import com.kaliware.payment.toolschallenge.dto.DescriptionDTO;

public class FactoryDescriptionDTO{

  public static DescriptionDTO craateRequestDescriptionDTO(){

    DescriptionDTO dto = new DescriptionDTO();
    dto.setValue("50.00");
    dto.setDatetime("01/12/2021 18:30:00");
    dto.setMerchant("PetShop Mundo Cão");

    return dto;
  }
}
