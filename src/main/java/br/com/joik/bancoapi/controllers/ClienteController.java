package br.com.joik.bancoapi.controllers;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.filter.ClienteFilter;
import br.com.joik.bancoapi.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
  private final ClienteService clienteService;

  @GetMapping("/todos")
  public ResponseEntity<List<Cliente>> findAllClientes() {
    List<Cliente> clientes = clienteService.findAll();
    return ResponseEntity.ok(clientes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> findByIdCliente(@PathVariable Long id) {
    return clienteService.findById(id);
  }

  @GetMapping("/filtrar")
  public ResponseEntity<Page<Cliente>> pesquisar(ClienteFilter clienteFilter, Pageable pageable) {
    return ResponseEntity.ok(clienteService.filtrar(clienteFilter, pageable));
  }
}
