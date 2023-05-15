package com.kaliware.payment.toolschallenge.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class BigDecimalUtils{
  public static BigDecimal BigDecimalConverter(String valor){
    return new BigDecimal(valor.replaceAll("[^\\d.-]", ""));
  }
}
