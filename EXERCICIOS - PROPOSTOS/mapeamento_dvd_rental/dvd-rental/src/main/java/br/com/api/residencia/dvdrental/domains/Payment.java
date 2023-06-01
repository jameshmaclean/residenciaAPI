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
@Table(name="paument")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paymend_id")
	private Integer paymentId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@OneToOne
	@JoinColumn(name="rental_id")
	private Rental rental;
	
	@Column(name="amount")
	private Double amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
}
