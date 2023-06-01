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
@Table(name="inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private Integer invId;
	
	@OneToOne
	@JoinColumn(name="film_id")
	private Film film;
	
	@OneToOne
	@JoinColumn(name="store_id")
	private Store store;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	
	
}
