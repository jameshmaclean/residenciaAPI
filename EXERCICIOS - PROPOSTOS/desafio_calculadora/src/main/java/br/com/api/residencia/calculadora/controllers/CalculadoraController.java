package br.com.api.residencia.calculadora.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.residencia.calculadora.services.CalculadoraService;

@RestController
@RequestMapping ("/calculadora")
public class CalculadoraController {
	@Autowired
	CalculadoraService calculadoraService;
	
	@GetMapping
	public String testar() {
		return "Teste OK";
	}
	
	@PostMapping ("/soma")
	public Double somar(@RequestBody Map<String, String> numeros) {
		return calculadoraService.calcular(numeros);
	}
	
	
	@GetMapping("/total")
	public Long total() {
		return calculadoraService.totalOp();
	}
	
}
