package br.senac.requestfood.model.contato;

public class Contato {

//    ATTRIBUTES
    private long id;
    private int telefone;
    private String email;

//    CONSTRUCTOR
    public Contato(long id, int telefone, String email) {
        setTelefone(telefone);
        setEmail(email);
    }

//    GET E SET
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
