package br.com.api.residencia.dvdrental.domains;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="film")
public class Film {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="film_id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	

	@Column(name="release_year")
	private Year year;
	
	@OneToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="rental_duration")
	private Integer rentDur;
	
	@Column(name="rental_rate")
	private Double rentalRate;
	
	@Column(name="lenght")
	private Integer lenght;
	
	@Column(name="replacement_cost")
	private Double replaceCost;
	
//	@Column(name="rating")
	
	
}
