package br.senac.requestfood.modelo.entidade.usuario;

import br.senac.requestfood.modelo.entidade.contato.Contato;

public class Usuario {

    private long id;
    private String nome;
    private Contato contato;

    // CONSTRUCTOR
    public Usuario (long id, String nome, Contato contato){
        setId(id);
        setNome(nome);
        setContato(contato);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

