package com.example.demo;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")

public class Teste {
	public static Map<Integer, String> db = new HashMap<>();
	public static int contador = 1;
	
	
	@GetMapping
	public Map<Integer, String> getMensagem() {
		return db; 
	}
	
	@GetMapping("/{contador}")
	public String getMensagem(@PathVariable Integer contador) {
		return db.get(contador);
	}
	
	@PostMapping
	public void setMensagem(@RequestBody String conteudo) {
		db.put(contador, conteudo);
		contador++;
	}
	
	@DeleteMapping ("/{contador}")
	public void deletaMensagem(@PathVariable Integer contador) {
		db.remove(contador);
	}
	
	@PutMapping ("/{contador}")
	public void atualizaMensagem(@PathVariable Integer contador, @RequestBody String conteudo) {
		db.put(contador, conteudo);
	}
}
