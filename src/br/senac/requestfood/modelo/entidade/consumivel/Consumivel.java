package br.senac.requestfood.modelo.entidade.consumivel;

import java.awt.*;

public class Consumivel {

//    ATTRIBUTES

    private String nome;
    private float valor;
    private String descricao;
    private Image imagem;

//    CONSTRUCTOR

    protected Consumivel(String nome, float valor, String descricao, Image imagem){
        setNome(nome);
        setValor(valor);
        setDescricao(descricao);
        setImagem(imagem);
    }

//    GET AND SET

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

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public Image getImagem() {
        return imagem;
    }

    //    METHODS
}
