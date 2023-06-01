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
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", nullable = false)
	private Integer addressId;

	@Column(name = "address", nullable = false, length = 50)
	private String address;

	@Column(name = "address2", length = 50)
	private String address2;

	@Column(name = "district", nullable = false, length = 50)
	private String district;

	@OneToOne
	@JoinColumn(name="city_id")
	private City city;

	@Column(name = "postal_code", length = 10)
	private String postalCode;

	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;

	
	public Address() {
	}


}
