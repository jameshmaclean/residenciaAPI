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
@Table(name="rental")
public class Rental {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="rental_id")
	private Integer rentalId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="rental_date")
	private LocalDateTime rentalDate;
	
	@OneToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@OneToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	
}
