package com.kaliware.payment.toolschallenge.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CreditCardUtils{
  public static boolean isValidCreditCardNumber(String creditCardNumber){
    creditCardNumber = creditCardNumber.replaceAll("\\s|-", "");

    if(!creditCardNumber.matches("\\d+")){
      return false;
    }

    int length = creditCardNumber.length();
    if(length < 13 || length > 19){
      return false;
    }

    int sum = 0;
    boolean doubleDigit = false;
    for(int i = length - 1; i >= 0; i--){
      int digit = Integer.parseInt(String.valueOf(creditCardNumber.charAt(i)));
      if(doubleDigit){
        digit *= 2;
        if(digit > 9){
          digit -= 9;
        }
      }
      sum += digit;
      doubleDigit = !doubleDigit;
    }

    return sum % 10 == 0;
  }

}
