package br.com.api.residencia.terapiy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.residencia.terapiy.domains.Profissional;

public interface ProfissionalRepository  extends JpaRepository<Profissional, Integer>{

	List<Profissional> findByAreaContaining(String area);
	List<Profissional> findByPrecoSocial(boolean precoSocial);
	List<Profissional> findByConvenio(boolean b);
	

}
