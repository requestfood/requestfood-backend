package br.senac.requestfood.model.itemadicional;

import br.senac.requestfood.model.item.Item;

public class ItemAdicional {

    private long id;
    private Item item;
    private String nomeAdicional;
    private int quantidade;

    public ItemAdicional(long id, Item item, String nomeAdicional, int quantidade) {

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

