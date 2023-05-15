package com.kaliware.payment.toolschallenge.services.exceptions;

public class InvalidPaymentException extends RuntimeException{
  public InvalidPaymentException(String message){
    super(message);
  }
}
