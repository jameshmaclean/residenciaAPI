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
@Table(name="country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", nullable = false)
	private Integer countryId;
	
	@Column(name="country", nullable=false, length = 50)
	private String country;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;
}
