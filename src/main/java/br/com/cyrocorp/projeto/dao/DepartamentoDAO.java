package br.com.cyrocorp.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.cyrocorp.projeto.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{

}
