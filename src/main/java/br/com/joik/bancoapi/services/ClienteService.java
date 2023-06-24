package br.com.joik.bancoapi.services;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.ClienteRepository;
import br.com.joik.bancoapi.repositories.filter.ClienteFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
  private final ClienteRepository clienteRepository;

  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  public ResponseEntity<Cliente> findById(Long id) {
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    if (optionalCliente.isPresent()) {
      Cliente cliente = optionalCliente.get();
      return ResponseEntity.ok(cliente);
    }
    return ResponseEntity.notFound().build();
  }

  public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
    return clienteRepository.filtrar(clienteFilter, pageable);
  }
}
