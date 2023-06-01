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
@Table(name="language")
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id")
	private Integer langId;
	
	@Column(name="name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
}
