package com.kaliware.payment.toolschallenge.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class NSUGenerator{
  public static String generateNSU(){
    LocalDateTime now = LocalDateTime.now();

    int sequence = (int) (Math.random() * 1000000);

    String nsu = String.format("%d%02d%02d%02d%02d%02d%06d",
        now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
        now.getHour(), now.getMinute(), now.getSecond(), sequence);

    return nsu;
  }

}
