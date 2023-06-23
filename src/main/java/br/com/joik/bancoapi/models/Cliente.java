package br.com.joik.bancoapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  @JsonIgnore
  @OneToMany(mappedBy = "cliente")
  private List<ContasPagar> contasPagar = new ArrayList<>();
}
