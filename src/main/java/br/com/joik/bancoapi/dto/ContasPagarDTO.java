package br.com.joik.bancoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ContasPagarDTO {
  private Long id;
  private LocalDate data;
  private LocalDate datavencimento;
  private BigDecimal valor;
  private String nomecliente;
}
