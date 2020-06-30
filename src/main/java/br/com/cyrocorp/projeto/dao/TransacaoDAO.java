package br.com.cyrocorp.projeto.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cyrocorp.projeto.dto.Contadores;
import br.com.cyrocorp.projeto.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	@Query("SELECT new br.com.cyrocorp.projeto.dto.Contadores(t.status, count(t.status)) FROM Transacao t WHERE agente.id=:id GROUP BY status")
	public ArrayList<Contadores> getTotaisPorId(@Param("id") int id);
}