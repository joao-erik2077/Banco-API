package br.com.joik.bancoapi.repositories.queries;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
  Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
