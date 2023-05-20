package br.com.residencia.api.springclothes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.api.springclothes.domains.Produto;
import br.com.residencia.api.springclothes.services.ProdutoService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	//LISTAR TODOS OS PRODUTOS COM ID
	@GetMapping
	public List<Produto> findAll(){
		return produtoService.findAll();
	}
	
	//CADASTRAR NOVOS PRODUTOS
	@PostMapping
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		return produtoService.cadastrarProduto(produto);
	}
	
	//REMOVER DETERMINADO PRODUTO
	@DeleteMapping("/{id}")
	public boolean deletarProduto(@PathVariable Long id) {
		return produtoService.deletarProduto(id);
	}
	
	//ATUALIZAR ALGUM PRODUTO
	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		return produtoService.atualizarProduto(id, produto);
	}
	
	//FILTRO POR NOMES
	@GetMapping("/byName")
	public List<Produto> buscarNome(@PathParam("name") String nome) {
		return produtoService.buscarNome(nome);
	}
	
	//FILTRO DE MENOR PRECO PRIMEIRO
	@GetMapping("/byPreco")
	public List<Produto> menorPreco() {
		return produtoService.menorPreco();
	}
		
}
