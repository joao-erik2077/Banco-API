package br.com.joik.bancoapi.repositories;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.queries.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {
}
