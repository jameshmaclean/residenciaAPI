package br.com.poo.residencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poo.residencia.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
