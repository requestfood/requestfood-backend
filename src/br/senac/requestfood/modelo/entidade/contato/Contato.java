package br.senac.requestfood.modelo.entidade.contato;

public class Contato {

    private long id;
    private int telefone;
    private String email;

    //CONSTRUCTOR
    public Contato(long id, int telefone, String email) {
        setTelefone(telefone);
        setEmail(email);


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
