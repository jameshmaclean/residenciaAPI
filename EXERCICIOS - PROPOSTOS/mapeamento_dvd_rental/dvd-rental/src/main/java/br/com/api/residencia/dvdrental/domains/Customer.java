package br.com.api.residencia.dvdrental.domains;

import java.time.LocalDate;
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
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false)
	private Integer customerId;
	
	@Column(name="store_id")
	private Integer store;
	
	@Column(name="first_name", nullable=false, length = 50)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length = 50)
	private String lastName;
	
	@Column(name="email", nullable=false, length = 50)
	private String email;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@Column(name="activebool")
	private boolean activeBl;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private LocalDate create;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	LocalDateTime lastUpdt;
	
	@Column(name="active")
	private Integer active;
	
}
