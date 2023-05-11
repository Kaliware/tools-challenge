package com.kaliware.payment.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDescriptionDTO{

  @JsonProperty("valor")
  private String value;

  @JsonProperty("dataHora")
  private String datetime;

  @JsonProperty("estabelecimento")
  private String merchant;
}
