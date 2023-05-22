package br.com.residencia.api.residenciaevil.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.api.residenciaevil.domains.Player;
import br.com.residencia.api.residenciaevil.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	public List<Player> findAll() {
		return playerRepository.findAll();
	}

	public Player inserirPlayer(Player player) {
		String strLocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		LocalDateTime date = LocalDateTime.parse(strLocalDateTime, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		player.setPlayerCreated(date);
		return playerRepository.save(player);
	}
	
	public Player atualizarPlayer(Long id, Player player) {
		Optional<Player> p1 = playerRepository.findById(id);
		Player playerDB = p1.get();
		playerDB.setPlayerClass(player.getPlayerClass());
		playerDB.setPlayerLevel(player.getPlayerLevel());
		playerDB.setPlayerName(player.getPlayerName());
		playerRepository.save(playerDB);
		return playerDB;
	}
	public boolean deletarPlayer(Long id) {
		Optional<Player> p1 = playerRepository.findById(id);
		Player playerDB = p1.get();
		playerDB.setActive(false);
		playerRepository.save(playerDB);
		return true;
	}
	
	public long quantidadePlayer() {
		return playerRepository.count();
	}
	
	public long playersAtivos() {
		return playerRepository.countByActive(true);
	}
	
	public List<Player>topLevel(){
		return playerRepository.findTop10ByOrderByPlayerLevelDesc();
	}
	
	
	  public List<Object[]> topClasses(){ return
	  playerRepository.topClasses(); 
	  }
	  
	  
	 //TABELA BOSS
	 // SPRITE PLAYERS
	  
	
	
}
