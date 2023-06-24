package br.com.joik.bancoapi.repositories.implementations;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.filter.ClienteFilter;
import br.com.joik.bancoapi.repositories.queries.ClienteQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClienteImpl implements ClienteQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
    return null;
  }
}
