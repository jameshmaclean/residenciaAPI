package br.com.api.residencia.terapiy.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.residencia.terapiy.domains.Profissional;
import br.com.api.residencia.terapiy.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	ProfissionalRepository profissionalRepository;

	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
	}

	public Profissional cadastrar(Profissional profissional) {
		String strLocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		LocalDateTime date = LocalDateTime.parse(strLocalDateTime, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		profissional.setCadastrado(date);
		profissional.setAtivo(true);

		return profissionalRepository.save(profissional);
	}

	public Optional<Profissional> findById(Integer id) {
		return profissionalRepository.findById(id);
	}

	public List<Profissional> findByArea(String area) {
		return profissionalRepository.findByAreaContaining(area);
	}

	public List<Profissional> findByPrecoSocial() {
		return profissionalRepository.findByPrecoSocial(true);
	}

	public String desativarProfissional(Integer id) {
		Optional<Profissional> p = profissionalRepository.findById(id);
		if (p.isPresent()) {
			Profissional profissional = p.get();
			profissional.setAtivo(false);
			profissionalRepository.save(profissional);
			return "Profissional Desativado";
		}
		return "ID não encontrado";
	}

	public Profissional atualizarDados(Integer id, Profissional profissional) {
		Optional<Profissional> p = profissionalRepository.findById(id);
		if (p.isPresent()) {
			Profissional profissionalBanco = p.get();
			profissional.setCadastrado(profissionalBanco.getCadastrado());
			profissional.setIdProfissional(profissionalBanco.getIdProfissional());
			profissional.setAtivo(profissionalBanco.isAtivo());
			profissionalRepository.save(profissional);
			return profissional;
		}
		return null;
	}

	public List<Profissional> findByConvenio() {
		return profissionalRepository.findByConvenio(true);
	}

}
