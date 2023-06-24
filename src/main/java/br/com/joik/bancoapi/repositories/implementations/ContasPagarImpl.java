package br.com.joik.bancoapi.repositories.implementations;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.filter.ContasPagarFilter;
import br.com.joik.bancoapi.repositories.queries.ContasPagarQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ContasPagarImpl implements ContasPagarQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<ContasPagar> filtrar(ContasPagarFilter contasPagarFilter, Pageable pageable) {
    return null;
  }
}
