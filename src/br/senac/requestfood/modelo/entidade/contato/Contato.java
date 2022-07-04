package br.senac.requestfood.modelo.entidade.contato;

public class Contato {

    private int telefone;
    private String email;

    public Contato (int telefone, String email){
        setTelefone(telefone);
        setEmail(email);


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
