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
@Table(name="store")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private Integer storeId;
	
	@OneToOne
	@JoinColumn(name="manager_staff_id")
	private Staff staff;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
}
