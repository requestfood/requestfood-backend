package br.senac.requestfood.model.itemadicional;

import br.senac.requestfood.model.item.Item;

import javax.persistence.*;

@Entity
@Table(name = "item_adicional")
public class ItemAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_adicional")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "nome_adicional", nullable = false, unique = true)
    private String nomeAdicional;

    @Column(name = "quantidade_adicional", nullable = false)
    private int quantidade;

    public ItemAdicional() {
    }

    public ItemAdicional(long id, Item item, String nomeAdicional, int quantidade) {
        setId(id);
        setItem(item);
        setNomeAdicional(nomeAdicional);
        setQuantidade(quantidade);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getNomeAdicional() {
        return nomeAdicional;
    }

    public void setNomeAdicional(String nomeAdicional) {
        this.nomeAdicional = nomeAdicional;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

