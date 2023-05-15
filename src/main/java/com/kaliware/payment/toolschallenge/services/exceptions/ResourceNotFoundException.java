package com.kaliware.payment.toolschallenge.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String message){
    super(message);
  }
}
