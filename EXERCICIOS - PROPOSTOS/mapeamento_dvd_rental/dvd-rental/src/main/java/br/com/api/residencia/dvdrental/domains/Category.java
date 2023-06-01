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
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false)
	private Integer categoryId;
	
	@Column(name="name", nullable=false, length = 25)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;


	
}
