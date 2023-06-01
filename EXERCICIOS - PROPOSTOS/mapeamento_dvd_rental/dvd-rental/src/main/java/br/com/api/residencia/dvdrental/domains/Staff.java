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
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Integer staffId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@Column(name="email")
	private String email;
	
	@OneToOne
	@JoinColumn(name="store_id")
	private Store store;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
}
