package com.kaliware.payment.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionDTO{

  @JsonProperty("cartao")
  private String card;

  private String id;

  @JsonProperty("descricao")
  private PaymentDescriptionDTO description;

  @JsonProperty("formaPagamento")
  private PaymentMethodDTO paymentMethod;



}
