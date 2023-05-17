package br.com.api.residencia.calculadora.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.residencia.calculadora.domains.Calculadora;
import br.com.api.residencia.calculadora.repositories.CalculadoraRepository;

@Service
public class CalculadoraService {
	@Autowired
	CalculadoraRepository calculadoraRepository;

	public Double calcular(Map<String, String> numeros) {
		Double resultado = null;
		Double num1 = Double.valueOf(numeros.get("num1"));
		Double num2 = Double.valueOf(numeros.get("num2"));

		String operacao = numeros.get("operacao");
		switch (operacao) {
		case "somar":
			resultado = somar(num1, num2);
			break;
		case "subtrair":
			resultado = subtrair(num1, num2);
			break;
		case "dividir":
			resultado = dividir(num1, num2);
			break;
		case "multiplicar":
			resultado = multiplicar(num1, num2);
			break;
		}

		String strLocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		LocalDateTime date = LocalDateTime.parse(strLocalDateTime, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		Calculadora calc = new Calculadora(operacao, num1, num2, resultado, date);
		
		calculadoraRepository.save(calc);
		
		return resultado;
	}

	private Double multiplicar(Double num1, Double num2) {
		return num1*num2;
	}

	private Double dividir(Double num1, Double num2) {
		return num1/num2;
	}

	private Double subtrair(Double num1, Double num2) {
		return num1-num2;
	}

	public Double somar(Double num1, Double num2) {
		return num1 + num2;
	}
	
	public long totalOp() {
		return calculadoraRepository.count();
	}

}
