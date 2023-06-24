package br.com.joik.bancoapi.repositories.implementations;

import br.com.joik.bancoapi.models.Cliente;
import br.com.joik.bancoapi.repositories.filter.ClienteFilter;
import br.com.joik.bancoapi.repositories.queries.ClienteRepositoryQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
    criteria.where(predicates);

    TypedQuery<Cliente> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<Cliente>(query.getResultList(), pageable, total(clienteFilter));
  }

  private long total(ClienteFilter clienteFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
    criteria.where(predicates);

    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistrosPorPagina);
  }

  private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(clienteFilter.getNome())) {
      predicates.add(builder.like(
          builder.lower(root.get("nome")),
          "%" + clienteFilter.getNome().toLowerCase() + "%"
      ));
    }

    return predicates.toArray(new Predicate[predicates.size()]);
  }
}
