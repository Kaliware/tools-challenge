package com.kaliware.payment.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO{

  @JsonProperty("cartao")
  @NotNull(message = "Número do Cartão não pode ser nulo!")
  @NotBlank(message = "Número do Cartão não pode estar em branco ou conter apenas espaços em branco!")
  private String card;

  @NotNull(message = "ID não pode ser nulo!")
  @NotBlank(message = "ID não pode estar em branco ou conter apenas espaços em branco!")
  private String id;

  @JsonProperty("formaPagamento")
  @NotNull(message = "formaPagamento não pode ser nulo!")
  @Valid
  private PaymentMethodDTO paymentMethod;


  @JsonProperty("descricao")
  @NotNull(message = "descricao não pode ser nulo!")
  @Valid
  private DescriptionDTO description;

}
