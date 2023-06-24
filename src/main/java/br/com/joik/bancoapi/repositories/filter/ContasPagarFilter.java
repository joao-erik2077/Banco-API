package br.com.joik.bancoapi.repositories.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ContasPagarFilter {
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate data;
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate datavencimento;
  private String nomecliente;
}
