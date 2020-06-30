package br.com.cyrocorp.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cyrocorp.projeto.dto.AgenteHeaders;
import br.com.cyrocorp.projeto.model.AgenteFinanceiro;

public interface AgenteFinanceiroDAO extends CrudRepository<AgenteFinanceiro, Integer> {
	public List<AgenteFinanceiro> findAllByOrderByVolumeDesc();
	
	@Query("SELECT new br.com.cyrocorp.projeto.dto.AgenteHeaders(ah.id, ah.nome) FROM AgenteFinanceiro ah ORDER BY ah.nome")
	public ArrayList<AgenteHeaders> getNomes();

}

