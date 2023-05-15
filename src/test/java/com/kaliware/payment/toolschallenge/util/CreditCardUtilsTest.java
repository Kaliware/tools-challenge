package com.kaliware.payment.toolschallenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.kaliware.payment.toolschallenge.utils.CreditCardUtils.isValidCreditCardNumber;

@ExtendWith(SpringExtension.class)
@DisplayName("CreditCardUtils Test")
public class CreditCardUtilsTest{
  @Test
  @DisplayName("should return true for valid credit card number")
  public void shouldReturnTrueForValidCreditCardNumber(){
    Assertions.assertTrue(isValidCreditCardNumber("1234 5678 9012 3452"));
  }

  @Test
  @DisplayName("should return false for invalid credit card number")
  public void shouldReturnFalseForInvalidCreditCardNumber(){
    Assertions.assertFalse(isValidCreditCardNumber("1234-5678-9012-3456-7"));
  }

  @Test
  @DisplayName("should return false for credit card number with letters")
  public void shouldReturnFalseForCreditCardNumberWithLetters(){
    Assertions.assertFalse(isValidCreditCardNumber("1234 5678 ABCD EFGH"));
  }

  @Test
  @DisplayName("should return false for credit card number with length less than 13")
  public void shouldReturnFalseForCreditCardNumberWithLengthLessThan13(){
    Assertions.assertFalse(isValidCreditCardNumber("123456789012"));
  }

  @Test
  @DisplayName("should return false for credit card number with length greater than 19")
  public void shouldReturnFalseForCreditCardNumberWithLengthGreaterThan19(){
    Assertions.assertFalse(isValidCreditCardNumber("12345678901234567890"));
  }

  @Test
  @DisplayName("should return false for credit card number with consecutive double digits")
  public void shouldReturnFalseForCreditCardNumberWithConsecutiveDoubleDigits(){
    Assertions.assertFalse(isValidCreditCardNumber("1234 5678 9912 3456"));
  }
}
