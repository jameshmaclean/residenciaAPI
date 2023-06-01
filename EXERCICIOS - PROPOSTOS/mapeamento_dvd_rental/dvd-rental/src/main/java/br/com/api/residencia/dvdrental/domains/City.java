package br.com.api.residencia.dvdrental.domains;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id", nullable = false)
	private Integer cityId;
	
	@Column(name="city", nullable=false, length = 50)
	private String cityName;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate; 
}
