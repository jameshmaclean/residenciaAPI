package com.example.demo;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
@RestController
@RequestMapping ("/calculadora")
public class calculadora {

	
	@PostMapping("/somar")
	
	public Integer soma(@RequestBody Map<String,Integer>numbs) {
		Integer somaTotal = 0;
		for(Entry<String, Integer> nm : numbs.entrySet()) {
			somaTotal+=nm.getValue();
		}
		return somaTotal;
	}
	
	@PostMapping("/sub")
	public Integer subt(@PathParam(value = "num1") Integer num1, @PathParam(value = "num2") Integer num2) {
		return num1-num2;
	}
	
	@PostMapping("/div/{num1}/{num2}")
	public Integer div(@PathVariable Integer num1, @PathVariable Integer num2) {
		return num1/num2;
	}
	
}