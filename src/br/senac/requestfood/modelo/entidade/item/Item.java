package br.senac.requestfood.modelo.entidade.item;

import br.senac.requestfood.modelo.entidade.adicionais.ItemAdicional;
import br.senac.requestfood.modelo.entidade.comanda.Comanda;
import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;
import br.senac.requestfood.modelo.entidade.usuario.estabelecimento.Estabelecimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {

    private long id;
    private Comanda comanda;
    private int quantidade;
    private Consumivel produto;
    private String observacao;

    private List<ItemAdicional> itensadicionais;

    public Item(int quantidade, String observacao) {
        setId(id);
        setComanda(comanda);
        setQuantidade(quantidade);
        setProduto(produto);
        setObservacao(observacao);
        itensadicionais = new ArrayList<>();
    }
    public boolean equals(Object objeto) {

        if (this == objeto)
            return true;

        if(objeto == null)
            return false;

        if (getClass() != objeto.getClass())
            return false;

        Item item = ((Item)objeto);

        return this.getId() == item.getId() && this.getComanda() == item.comanda && this.getQuantidade() == item.getQuantidade() && this.getProduto() == item.getProduto() && this.getObservacao().equals(getObservacao());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<ItemAdicional> getItensadicionais() {
        return itensadicionais;
    }
}
