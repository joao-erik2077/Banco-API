package br.com.joik.bancoapi.services;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.ContasPagarRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContasPagarService {
  private final ContasPagarRepository contasPagarRepository;

  public List<ContasPagar> findAll() {
    return contasPagarRepository.findAll();
  }

  public ResponseEntity<ContasPagar> findById(Long id) {
    Optional<ContasPagar> contasPagarOptional = contasPagarRepository.findById(id);
    if (contasPagarOptional.isPresent()) {
      ContasPagar contasPagar = contasPagarOptional.get();
      return ResponseEntity.ok(contasPagar);
    }
    return ResponseEntity.notFound().build();
  }
}
