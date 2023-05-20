package br.com.api.residencia.calculadora.domains;


import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="operacoes")
public class Calculadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_operacao")
	private Integer id_operacao;
	
	@Column(name="tipo_operacao", length = 15, nullable = false)
	private String tipo_operacao;
	
	@Column(name="num_1", nullable = false)
	private Double num_1;
	
	@Column(name="num_2", nullable = false)
	private Double num_2;
	
	@Column(name="resultado", nullable = false)
	private Double resultado;
	
	@Column(name="data_op", nullable=false)
	private LocalDateTime data_op;
	

	public Calculadora(String tipo_operacao, Double num_1, Double num_2, Double resultado, LocalDateTime date) {
		super();
		this.tipo_operacao = tipo_operacao;
		this.num_1 = num_1;
		this.num_2 = num_2;
		this.resultado = resultado;
		this.data_op = date;
	}
	public Calculadora() {
		
	}

	public Integer getId_operacao() {
		return id_operacao;
	}

	public void setId_operacao(Integer id_operacao) {
		this.id_operacao = id_operacao;
	}

	public String getTipo_operacao() {
		return tipo_operacao;
	}

	public void setTipo_operacao(String tipo_operacao) {
		this.tipo_operacao = tipo_operacao;
	}

	public Double getNum_1() {
		return num_1;
	}

	public void setNum_1(Double num_1) {
		this.num_1 = num_1;
	}

	public Double getNum_2() {
		return num_2;
	}

	public void setNum_2(Double num_2) {
		this.num_2 = num_2;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public LocalDateTime getData_op() {
		return data_op;
	}

	public void setData_op(LocalDateTime data_op) {
		this.data_op = data_op;
	}
	
	
}
