package br.senac.requestfood.model.item;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Comanda comanda;

    @Column(name = "quantidade_item", nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consumivel", nullable = false)
    private Consumivel produto;

    @Column(name = "observacao_item", length = 100)
    private String observacao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemAdicional> itensadicionais;

    public Item(long id, Comanda comanda, int quantidade, Consumivel produto, String observacao) {
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
