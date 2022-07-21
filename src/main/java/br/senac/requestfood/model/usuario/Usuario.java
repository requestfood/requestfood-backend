package br.senac.requestfood.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.senac.requestfood.model.contato.Contato;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_usuario", nullable = false, length = 45)
	private String nome;

	protected Usuario() {}

	protected Usuario(Long id, String nome, Contato contato) {
		setId(id);
		setNome(nome);
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}