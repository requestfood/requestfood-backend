package br.senac.requestfood.modelo.entidade.item;

import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;

public class Item {

    private int quantidade;
    private Consumivel produto;
    private String observacao;

    public Item(int quantidade, String observacao){
        setQuantidade(quantidade);
        setObservacao(observacao);
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
}
