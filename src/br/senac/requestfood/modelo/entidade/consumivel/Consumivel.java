package br.senac.requestfood.modelo.entidade.consumivel;

import br.senac.requestfood.modelo.entidade.usuario.estabelecimento.Estabelecimento;

import java.awt.*;

public abstract class Consumivel {

//    ATTRIBUTES

    private long id;
    private Estabelecimento estabelecimento;
    private String nome;
    private float valor;
    private String descricao;
    private Byte[] imagem;

//    CONSTRUCTOR

    protected Consumivel(String nome, float valor, String descricao, Byte[] imagem){
        setNome(nome);
        setValor(valor);
        setDescricao(descricao);
        setImagem(imagem);
    }

//    equals

    public boolean equals(Object objeto) {
        if (objeto == null)
            return false;
        if (this == objeto)
            return true;
        if (this.getClass() != objeto.getClass())
            return false;
        Consumivel consumivel = ((Consumivel)objeto);
        return this.getId() == consumivel.getId()
                && this.getEstabelecimento().equals(consumivel.getEstabelecimento())
                && this.getNome().equals(consumivel.getNome())
                && this.getValor() == consumivel.getValor()
                && this.getDescricao().equals(consumivel.getDescricao())
                && this.getImagem().equals(consumivel.getImagem());
    }


//    GET AND SET


    public void setId(long id) {
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


    //    METHODS


}
