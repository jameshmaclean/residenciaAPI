package br.com.residencia.api.springclothes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.api.springclothes.domains.Produto;
import br.com.residencia.api.springclothes.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto cadastrarProduto(Produto produto) {
		if (produto.getNomeProduto().equals(null) || produto.getPreco().equals(null)
				|| produto.getQuantidade().equals(null)) {
			return null;
		} else {
			return produtoRepository.save(produto);
		}
	}
	public boolean deletarProduto(Long id) {
		produtoRepository.deleteById(id);
		return true;
	}
	
	public Produto atualizarProduto(Long id, Produto produto) {
		Optional<Produto>p = produtoRepository.findById(id);
		Produto produtoDB = p.get();
		produtoDB.setNomeProduto(produto.getNomeProduto());
		produtoDB.setPreco(produto.getPreco());
		produtoDB.setQuantidade(produto.getQuantidade());
		produtoRepository.save(produtoDB);
		return produtoDB;
	}
	
	public Produto atualizarEstoque(Long id, Produto produto) {
		Optional<Produto>p = produtoRepository.findById(id);
		Produto produtoDB = p.get();
		produtoDB.setQuantidade(produto.getQuantidade());
		produtoRepository.save(produtoDB);
		return produtoDB;
	}
	public List<Produto> buscarNome(String nome) {
		return produtoRepository.findByNomeProdutoContaining(nome);
		 	
	}
	
	public List<Produto>menorPreco(){
		return produtoRepository.findAllByOrderByPrecoAsc();
	}
}
