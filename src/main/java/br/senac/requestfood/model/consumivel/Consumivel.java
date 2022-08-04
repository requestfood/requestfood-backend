package br.senac.requestfood.model.consumivel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "consumivel")
public abstract class Consumivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consumivel")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Estabelecimento estabelecimento;

	@Column(name = "nome_consumivel", length = 45, nullable = false)
	private String nome;

	@Column(name = "valor_consumivel", nullable = false)
	private Double valor;

	@Column(name = "descricao_consumivel", length = 200)
	private String descricao;

	@Lob
	@Column(name = "imagem_consumivel")
	private Byte[] imagem;

	protected Consumivel(Long id, Estabelecimento estabelecimento, String nome, Double valor, String descricao, Byte[] imagem) {
		this.id = id;
		this.estabelecimento = estabelecimento;
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	protected Consumivel() {}

	public boolean equals(Object objeto) {
		if (objeto == null)
			return false;
		if (this == objeto)
			return true;
		if (this.getClass() != objeto.getClass())
			return false;
		Consumivel consumivel = ((Consumivel) objeto);
		return this.getId() == consumivel.getId() && this.getEstabelecimento().equals(consumivel.getEstabelecimento())
				&& this.getNome().equals(consumivel.getNome()) && this.getValor() == consumivel.getValor()
				&& this.getDescricao().equals(consumivel.getDescricao())
				&& this.getImagem().equals(consumivel.getImagem());
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setImagem(Byte[] imagem) {
		this.imagem = imagem;
	}

	public Byte[] getImagem() {
		return imagem;
	}
}