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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_usuario")
	private Estabelecimento estabelecimento;

	@Column(name = "nome_consumivel", length = 45, nullable = false)
	private String nome;

	@Column(name = "valor_consumivel", nullable = false)
	private float valor;

	@Column(name = "descricao_consumivel", length = 200)
	private String descricao;

	@Lob
	@Column(name = "imagem_consumivel")
	private Byte[] imagem;

	protected Consumivel(Long id, Estabelecimento estabelecimento, String nome, float valor, String descricao, Byte[] imagem) {
		setId(id);
		setEstabelecimento(estabelecimento);
		setNome(nome);
		setValor(valor);
		setDescricao(descricao);
		setImagem(imagem);
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
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