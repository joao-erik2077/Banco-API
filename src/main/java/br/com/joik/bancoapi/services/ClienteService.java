package br.com.joik.bancoapi.services;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
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
}
