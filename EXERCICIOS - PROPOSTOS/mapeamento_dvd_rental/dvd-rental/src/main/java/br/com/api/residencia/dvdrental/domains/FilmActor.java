package br.com.api.residencia.dvdrental.domains;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="film_actor")
public class FilmActor {
	
	@Id
	@OneToOne
	@JoinColumn(name="actor_id")
	private Actor actor;
	
	@OneToOne
	@JoinColumn(name="film_id")
	private Film film;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
}
