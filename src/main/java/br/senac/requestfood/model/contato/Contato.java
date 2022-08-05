package br.senac.requestfood.model.contato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "telefone_contato", nullable = false, length = 11, unique = true)
	private String telefone;

	@Column(name = "email_contato", nullable = false, length = 50, unique = true)
	private String email;

	public Contato() {}

	public Contato(Long id ,String telefone, String email) {
		setId(id);
		setTelefone(telefone);
		setEmail(email);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}