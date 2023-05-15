package com.kaliware.payment.toolschallenge.services.exceptions;

public class OperationAlreadyPerformedException extends RuntimeException{
  public OperationAlreadyPerformedException(String message){
    super(message);
  }
}
