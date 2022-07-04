package br.senac.requestfood.modelo.entidade.usuario;

import br.senac.requestfood.modelo.entidade.contato.Contato;

public class Usuario {

    private int id;
    private String nome;
    private Contato contato;

    // CONSTRUCTOR
    public Usuario (int id, String nome, Contato contato){
        setId(id);
        setNome(nome);
        setContato(contato);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}

