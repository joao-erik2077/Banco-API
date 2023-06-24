package br.com.joik.bancoapi.repositories.implementations;

import br.com.joik.bancoapi.dto.ContasPagarDTO;
import br.com.joik.bancoapi.models.ContasPagar;
import br.com.joik.bancoapi.repositories.filter.ContasPagarFilter;
import br.com.joik.bancoapi.repositories.queries.ContasPagarRepositoryQuery;
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

public class ContasPagarRepositoryImpl implements ContasPagarRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<ContasPagarDTO> filtrar(ContasPagarFilter contasPagarFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ContasPagarDTO> criteria = builder.createQuery(ContasPagarDTO.class);
    Root<ContasPagar> root = criteria.from(ContasPagar.class);

    criteria.select(builder.construct(ContasPagarDTO.class,
        root.get("id"),
        root.get("data"),
        root.get("datavencimento"),
        root.get("valor"),
        root.get("cliente").get("nome")
    ));

    Predicate[] predicates = criarRestricoes(contasPagarFilter, builder, root);
    criteria.where(predicates);

    TypedQuery<ContasPagarDTO> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<ContasPagarDTO>(query.getResultList(), pageable, total(contasPagarFilter));
  }

  private long total(ContasPagarFilter contasPagarFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<ContasPagar> root = criteria.from(ContasPagar.class);

    Predicate[] predicates = criarRestricoes(contasPagarFilter, builder, root);
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

  private Predicate[] criarRestricoes(ContasPagarFilter contasPagarFilter, CriteriaBuilder builder, Root<ContasPagar> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(contasPagarFilter.getNomecliente())) {
      predicates.add(builder.like(
          builder.lower(root.get("cliente").get("nome")),
          "%" + contasPagarFilter.getNomecliente().toLowerCase() + "%"
      ));
    }
    if (contasPagarFilter.getData() != null) {
      predicates.add(builder.equal(
          root.get("data"),
          contasPagarFilter.getData()
      ));
    }
    if (contasPagarFilter.getDatavencimento() != null) {
      predicates.add(builder.equal(
          root.get("datavencimento"),
          contasPagarFilter.getDatavencimento()
      ));
    }

    return predicates.toArray(new Predicate[predicates.size()]);
  }
}
