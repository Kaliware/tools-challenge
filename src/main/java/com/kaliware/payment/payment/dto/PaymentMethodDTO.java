package com.kaliware.payment.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDTO{

  @JsonProperty("tipo")
  private String type;

  @JsonProperty("parcelas")
  private String Installments;
}
