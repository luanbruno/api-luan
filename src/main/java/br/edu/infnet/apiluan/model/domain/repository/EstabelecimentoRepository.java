package br.edu.infnet.apiluan.model.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiluan.model.domain.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, Integer> {
}
