package br.com.api.residencia.dvdrental.domains;

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
@Table(name="actor")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id", nullable = false)
	private Integer actorId;
	
	@Column(name="first_name",nullable = false, length = 45)
	private String firstName;
	
	@Column(name="last_name",nullable = false, length = 45)
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update",nullable = false)
	private LocalDateTime lastUpdate;
	
	public Actor() {
		super();
	}
	
	
}
