package br.com.joik.bancoapi.repositories;

import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.queries.ContasPagarQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContasPagar, Long>, ContasPagarQuery {
}
