package br.com.joik.bancoapi.repositories.queries;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.filter.ContasPagarFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasPagarQuery {
  Page<ContasPagar> filtrar(ContasPagarFilter contasPagarFilter, Pageable pageable);
}
