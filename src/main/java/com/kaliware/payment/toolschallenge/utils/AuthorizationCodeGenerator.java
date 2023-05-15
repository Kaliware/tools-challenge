package com.kaliware.payment.toolschallenge.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorizationCodeGenerator{
  public static String generateAuthorizationCode(){
    int randomNumber = (int) (Math.random() * (99999999 - 10000000 + 1) + 10000000);
    return String.format("%08d", randomNumber);
  }


}
