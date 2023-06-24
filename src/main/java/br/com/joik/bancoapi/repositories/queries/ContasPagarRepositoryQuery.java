package br.com.joik.bancoapi.repositories.queries;

import br.com.joik.bancoapi.dto.ContasPagarDTO;
import br.com.joik.bancoapi.repositories.filter.ContasPagarFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasPagarRepositoryQuery {
  Page<ContasPagarDTO> filtrar(ContasPagarFilter contasPagarFilter, Pageable pageable);
}
