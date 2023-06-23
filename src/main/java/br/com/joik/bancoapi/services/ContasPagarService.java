package br.com.joik.bancoapi.services;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.ContasPagarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContasPagarService {
  private final ContasPagarRepository contasPagarRepository;

  public List<ContasPagar> findAll() {
    return contasPagarRepository.findAll();
  }
}
