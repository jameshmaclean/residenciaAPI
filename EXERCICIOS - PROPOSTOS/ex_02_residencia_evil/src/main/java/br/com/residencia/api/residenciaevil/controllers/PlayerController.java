package br.com.residencia.api.residenciaevil.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.api.residenciaevil.domains.Player;
import br.com.residencia.api.residenciaevil.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	//LISTA TODOS OS PLAYERS
	public ResponseEntity<List<Player>> findAll() {
		 List<Player> players = playerService.findAll();
		 return ResponseEntity.status(HttpStatus.OK).body(players);
	}
	
	//ADCIONAR NOVO PLAYER - METODO DE CADASTRO
	@PostMapping
	public ResponseEntity<Player> inserirPlayer(@RequestBody Player player) {
		playerService.inserirPlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).body(player);
	}
	
	//ATUALIZAR PLAYER PASSANDO O ID
	@PutMapping("/{id}")
	public ResponseEntity<Player> atualizarPlayer(@PathVariable Long id, @RequestBody Player player) {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.atualizarPlayer(id, player));
	}
	
	//DELETE LÓGICO POR ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletarPlayer(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.deletarPlayer(id));
	}
	
	//MOSTRAR QUANTIDADE TOTAL DE PLAYERS 
	@GetMapping("/total")
	public ResponseEntity<Long> quantidadePlayer() {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.quantidadePlayer());
	}
	
	//MOSTRAR QUANTIDADE DE PLAYERS ATIVOS IGNORANDO OS DELETADOS
	@GetMapping("/ativos")
	public ResponseEntity<Long> playersAtivos() {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.playersAtivos());
	}
	
	//RANKING ORDENADO DE MAIOR LEVEL PARA MENOR LEVEL
	@GetMapping("/topLevel")
	public ResponseEntity<List<Player>> topLevel() {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.topLevel());
	}
	
	//EXIBE AS CLASSES MAIS JOGADAS
	@GetMapping("/topClasses")
	public ResponseEntity<List<Object[]>> topClasses() {
		return ResponseEntity.status(HttpStatus.OK).body(playerService.topClasses());
	}

}
