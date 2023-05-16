package br.com.poo.residencia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.poo.residencia.models.Produto;
import br.com.poo.residencia.repositories.ProdutoRepository;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("byId")
	public Optional<Produto> listarById(@PathParam("id") Long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public boolean registrar(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return true;	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto p, @PathVariable Long id){
		Optional<Produto> prd = produtoRepository.findById(id);
		if (!prd.isPresent()) {
			return ResponseEntity.notFound().build();
			}
		Produto produtoDB = prd.get();
		produtoDB.setDesc(p.getDesc());
		produtoDB.setNome(p.getNome());
		produtoDB.setQtd(p.getQtd());
		produtoDB.setValor(p.getValor());
		p = produtoRepository.save(produtoDB);
		return ResponseEntity.ok(p);
		
	}
	
	@DeleteMapping("/{id}")
	public boolean deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return true;
	}

}
