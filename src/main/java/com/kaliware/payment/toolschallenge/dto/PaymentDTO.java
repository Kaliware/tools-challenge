package com.kaliware.payment.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO{

  @JsonProperty("transacao")
  @NotNull(message = "Transação não pode ser nula!")
  @Valid
  private TransactionDTO transaction;

}
