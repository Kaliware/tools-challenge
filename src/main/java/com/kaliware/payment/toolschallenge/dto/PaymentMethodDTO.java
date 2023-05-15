package com.kaliware.payment.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodDTO{

  @JsonProperty("tipo")
  @NotNull(message = "tipo não pode ser nulo!")
  @NotBlank(message = "Tipo não pode estar em branco ou conter apenas espaços em branco!")
  private String type;

  @JsonProperty("parcelas")
  @NotNull(message = "Parcelas não pode ser nula!")
  @NotBlank(message = "Parcelas não pode estar em branco ou conter apenas espaços em branco!")
  private String Installments;
}
