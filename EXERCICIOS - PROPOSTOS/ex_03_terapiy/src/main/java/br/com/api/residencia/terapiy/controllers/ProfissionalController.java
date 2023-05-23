package br.com.api.residencia.terapiy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.residencia.terapiy.domains.Profissional;
import br.com.api.residencia.terapiy.services.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
	@Autowired
	ProfissionalService profissionalService;

	//Retorna uma lista com todos os profissionais registrados no sistema
	@Operation(description = "Retorna uma lista com todos os profissionais registrados no sistema")
	@GetMapping
	public List<Profissional>findAll(){
		return profissionalService.findAll();
	}
	
	//Inclui o profissional cadastrado no banco de dados
	@Operation(description = "Inclui o profissional cadastrado no banco de dados")
	@PostMapping
	public Profissional cadastrar(@RequestBody Profissional profissional) {
		return profissionalService.cadastrar(profissional);
	}
	
	//Retorna um profissional com determinado ID
	@Operation(description = "Retorna um profissional com determinado ID")
	@GetMapping("/byId")
	public Optional<Profissional> findById(@PathParam("id") Integer id) {
		return profissionalService.findById(id);
	}
	
	//Retorna uma lista com todos os profissionais de determinada área
	@Operation(description = "Retorna uma lista com todos os profissionais de determinada área")
	@GetMapping("/byArea")
	public List<Profissional>findByArea(@PathParam("area") String area){
		return profissionalService.findByArea(area);
	}
	
	//Retorna uma lista com todos os profissionais que oferecem preço social
	@Operation(description = "Retorna uma lista com todos os profissionais que oferecem preço social")
	@GetMapping("/precoSocial")
	public List<Profissional> findByPrecoSocial() {
		return profissionalService.findByPrecoSocial();
	}
	
	//Retorna uma lista com todos os profissionais que oferecem preço social
	@Operation(description = "Retorna uma lista com todos os profissionais que oferecem atendimento por convenio")
	@GetMapping("/convenio")
	public List<Profissional> findByConvenio() {
		return profissionalService.findByConvenio();
	}
	
	//Desativar determinado profissional por id
	@Operation(description="Setar o campo ativo do profissional para false")
	@DeleteMapping("/desativar")
	public String desativarProfissional(@PathParam ("id")Integer id) {
		return profissionalService.desativarProfissional(id);
	}
	
	//Aualizar dados do profissional passando o ID
	@Operation(description="Atualizar os dados de um determinado profissional passado pelo ID")
	@PutMapping ("/atualizar")
	public Profissional atualizarDados(@PathParam("id") Integer id, @RequestBody Profissional profissional){
		return profissionalService.atualizarDados(id, profissional);
	}
	
	
}
