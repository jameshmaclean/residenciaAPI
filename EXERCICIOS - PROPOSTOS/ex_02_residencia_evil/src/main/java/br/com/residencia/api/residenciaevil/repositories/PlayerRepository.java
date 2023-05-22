package br.com.residencia.api.residenciaevil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.residencia.api.residenciaevil.domains.Player;
public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findTop10ByOrderByPlayerLevelDesc();

	Long countByActive(boolean active);
	
	@Query("SELECT p.playerClass, COUNT(p.playerClass) FROM Player p GROUP BY p.playerClass ORDER BY COUNT(p.playerClass) DESC")
	List<Object[]> topClasses();

}
