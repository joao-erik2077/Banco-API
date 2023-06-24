package br.com.joik.bancoapi.repositories.filter;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ContasPagarFilter {
  private LocalDate data;
  private LocalDate datavencimento;
  private BigDecimal valor;
  private String nomecliente;
}
