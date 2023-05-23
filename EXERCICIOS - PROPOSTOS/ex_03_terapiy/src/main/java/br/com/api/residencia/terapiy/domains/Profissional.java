package br.com.api.residencia.terapiy.domains;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="profissional")
public class Profissional {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_cd_id")
	private Integer idProfissional;
	
	@NotNull
	@Size(max = 50)
	@Column(name="pro_tx_nome")
	private String nome;
	
	@NotNull
	@Size(max = 50)
	@Column(name="pro_tx_sobrenome")
	private String sobrenome;
	
	@NotNull
	@Size(min = 10, max = 50)
	@Column(name="pro_tx_endereco")
	private String endereco;
	
	@NotNull
	@Size(min = 9, max = 11)
	@Column(name="pro_tx_telefone")
	private String telefone;
	
	@NotNull
	@Size(min = 10, max = 50)
	@Email
	@Column(name="pro_tx_email")
	private String email;

	@NotNull
	@Size(max = 40, message = "No máximo 50 caracteres")
	@Column(name="pro_tx_area")
	private String area;
	
	@NotNull
	@Column(name="pro_bl_social")
	private boolean precoSocial;
	
	@NotNull
	@Column(name="pro_bl_convenio")
	private boolean convenio;
	
	@NotNull
	@Column(name="pro_bl_ativo")
	private boolean ativo;
	
	@NotNull
	@Column(name="pro_dt_cadastrado")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime cadastrado;
	
	public Profissional() {
		super();
	}

	public Profissional(Integer idProfissional, @NotNull @Size(max = 50) String nome,
			@NotNull @Size(max = 50) String sobrenome, @NotNull @Size(min = 10, max = 50) String endereco,
			@NotNull @Size(min = 9, max = 11) String telefone, @NotNull @Size(min = 10, max = 50) @Email String email,
			@NotNull @Size(max = 50) String area, @NotNull boolean precoSocial, LocalDateTime cadastrado) {
		super();
		this.idProfissional = idProfissional;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.area = area;
		this.precoSocial = precoSocial;
		this.cadastrado = cadastrado;
	}

	public LocalDateTime getCadastrado() {
		return cadastrado;
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setCadastrado(LocalDateTime cadastrado) {
		this.cadastrado = cadastrado;
	}

	public Integer getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Integer idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public boolean isPrecoSocial() {
		return precoSocial;
	}

	public void setPrecoSocial(boolean precoSocial) {
		this.precoSocial = precoSocial;
	}
		
}
