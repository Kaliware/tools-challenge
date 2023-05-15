package com.kaliware.payment.toolschallenge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnmPaymentMethod{
  AVISTA("AVISTA"),
  PARCELADO_LOJA("PARCELADO LOJA"),
  PARCELADO_EMISSOR("PARCELADO EMISSOR");

  private String name;


}
