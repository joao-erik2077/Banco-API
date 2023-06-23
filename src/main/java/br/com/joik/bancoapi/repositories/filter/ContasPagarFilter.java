package br.com.joik.bancoapi.repositories.filter;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContasPagarFilter {
  private LocalDate data;
  private LocalDate datavencimento;
  private BigDecimal valor;
  private String nomecliente;
}
