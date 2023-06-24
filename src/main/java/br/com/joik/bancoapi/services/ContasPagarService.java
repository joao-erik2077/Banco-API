package br.com.joik.bancoapi.services;

import br.com.joik.bancoapi.dto.ContasPagarDTO;
import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.ContasPagarRepository;
import br.com.joik.bancoapi.repositories.filter.ContasPagarFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  public Page<ContasPagarDTO> filtrar(ContasPagarFilter contasPagarFilter, Pageable pageable) {
    return contasPagarRepository.filtrar(contasPagarFilter, pageable);
  }
}
