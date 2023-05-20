package br.com.residencia.api.springclothes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.api.springclothes.domains.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeProdutoContaining(String nome);
	List<Produto> findAllByOrderByPrecoAsc();

}
