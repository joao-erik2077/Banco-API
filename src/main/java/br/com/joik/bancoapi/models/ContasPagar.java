package br.com.joik.bancoapi.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "contaspagar")
public class ContasPagar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "idcliente")
  private Cliente cliente;
  private LocalDate data;
  private LocalDate datavencimento;
  private BigDecimal valor;
}
