package com.kaliware.payment.toolschallenge.controllers.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
public class StandardError implements Serializable{

  private static final long serialVersionUID = 1L;

  private Instant timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;
}
