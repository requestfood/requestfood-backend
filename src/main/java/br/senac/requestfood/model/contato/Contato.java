package br.senac.requestfood.model.contato;

import javax.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {

//    ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_contato")
    private long id;

    @Column(name = "telefone_contato", nullable = false, length = 11)
    private String telefone;

    @Column(name = "email_contato", nullable = false, length = 50, unique = true)
    private String email;

    public Contato() {
    }

    //    CONSTRUCTOR
    public Contato(long id, String telefone, String email) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
