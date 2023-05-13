package com.kaliware.payment.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentDescriptionResponseDTO extends PaymentDescriptionDTO{
  private String nsu;

  @JsonProperty("codigoAutorizacao")
  private String authorizationCode;

  private String status;
}
