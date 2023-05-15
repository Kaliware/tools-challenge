package com.kaliware.payment.toolschallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaliware.payment.toolschallenge.enums.EnmPaymentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionDTO{

  @JsonProperty("valor")
  @NotNull(message = "Valor não pode ser nulo!")
  @NotBlank(message = "Valor não pode estar em branco ou conter apenas espaços em branco!")
  private String value;

  @JsonProperty("dataHora")
  @NotNull(message = "dataHora não pode ser nulo!")
  @NotBlank(message = "dataHora não pode estar em branco ou conter apenas espaços em branco!")
  @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}$", message = "Formato da Data inválida!")
  private String datetime;

  @JsonProperty("estabelecimento")
  @NotNull(message = "estabelecimento não pode ser nulo!")
  @NotBlank(message = "estabelecimento não pode estar em branco ou conter apenas espaços em branco!")
  private String merchant;

  private String nsu;

  @JsonProperty("codigoAutorizacao")
  private String authorizationCode;

  private EnmPaymentStatus status;
}
