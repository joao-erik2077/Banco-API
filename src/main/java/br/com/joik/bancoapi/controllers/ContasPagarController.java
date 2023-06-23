package br.com.joik.bancoapi.controllers;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.services.ContasPagarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contaspagar")
@AllArgsConstructor
public class ContasPagarController {
  private final ContasPagarService contasPagarService;

  @GetMapping("/todos")
  public ResponseEntity<List<ContasPagar>> findAllContasPagar() {
    List<ContasPagar> contasPagar = contasPagarService.findAll();
    return ResponseEntity.ok(contasPagar);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ContasPagar> findByIdContasPagar(@PathVariable Long id) {
    return contasPagarService.findById(id);
  }
}
