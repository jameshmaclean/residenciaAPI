package br.com.residencia.api.residenciaevil.domains;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pla_cd_id")
	private Long playerId;

	@Column(name = "pla_tx_name", length = 25, nullable = false)
	private String playerName;

	@Column(name = "pla_tx_class", length = 15, nullable = false)
	private String playerClass;

	@Column(name = "pla_tx_level", nullable = false)
	private Integer playerLevel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pla_dt_created", nullable = false)
	private LocalDateTime playerCreated;
	
	@Column(name="pla_bl_active")
	private boolean active;

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public Integer getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(Integer playerLevel) {
		this.playerLevel = playerLevel;
	}

	public LocalDateTime getPlayerCreated() {
		return playerCreated;
	}

	public void setPlayerCreated(LocalDateTime playerCreated) {
		this.playerCreated = playerCreated;
	}

}
