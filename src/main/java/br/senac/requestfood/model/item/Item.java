package br.senac.requestfood.model.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comanda", nullable = false)
	private Comanda comanda;

	@Column(name = "quantidade_item", nullable = false)
	private int quantidade;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	@JoinColumn(name = "id_consumivel", nullable = false)
	private Consumivel produto;

	@Column(name = "observacao_item", length = 100)
	private String observacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemAdicional> itensAdicionais;

	public Item() {}

	public Item(Long id, Comanda comanda, int quantidade, Consumivel produto, String observacao) {
		setId(id);
		setComanda(comanda);
		setQuantidade(quantidade);
		setProduto(produto);
		setObservacao(observacao);
		itensAdicionais = new ArrayList<>();
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		if (getClass() != objeto.getClass())
			return false;

		Item item = ((Item) objeto);

		return this.getId() == item.getId() && this.getComanda() == item.comanda
				&& this.getQuantidade() == item.getQuantidade() && this.getProduto() == item.getProduto()
				&& this.getObservacao().equals(getObservacao());
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setProduto(Consumivel produto) {
		this.produto = produto;
	}

	public Consumivel getProduto() {
		return produto;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public List<ItemAdicional> getItensAdicionais() {
		return itensAdicionais;
	}

	public void adicionarItemAdicional(ItemAdicional itemAdicional) {
		itensAdicionais.add(itemAdicional);
	}

	public void removerItemAdicional(ItemAdicional itemAdicional) {
		itensAdicionais.remove(itemAdicional);
	}
}