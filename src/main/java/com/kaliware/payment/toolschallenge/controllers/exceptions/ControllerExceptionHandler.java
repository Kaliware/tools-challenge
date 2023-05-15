package com.kaliware.payment.toolschallenge.controllers.exceptions;


import com.kaliware.payment.toolschallenge.services.exceptions.InvalidPaymentException;
import com.kaliware.payment.toolschallenge.services.exceptions.OperationAlreadyPerformedException;
import com.kaliware.payment.toolschallenge.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_FOUND;

    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(e.getClass().getSimpleName());
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(OperationAlreadyPerformedException.class)
  public ResponseEntity<StandardError> database(OperationAlreadyPerformedException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(e.getClass().getSimpleName());
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(InvalidPaymentException.class)
  public ResponseEntity<StandardError> invalidPaymentException(InvalidPaymentException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(e.getClass().getSimpleName());
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DateTimeException.class)
  public ResponseEntity<StandardError> validationError(DateTimeException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(e.getClass().getSimpleName());
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, HttpServletRequest request){
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(e.getClass().getSimpleName());
    err.setMessage(getValidationErrorMessage(e.getBindingResult().getFieldErrors()));
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  private String getValidationErrorMessage(List<FieldError> errors){
    StringBuilder sb = new StringBuilder();
    for(FieldError error : errors){
      sb.append(error.getDefaultMessage());
      break;
    }
    return sb.toString();
  }

}