package br.senac.requestfood.model.usuario;

import javax.persistence.*;
import br.senac.requestfood.model.contato.Contato;

@Entity
@Table(name = "usuario")
public abstract class Usuario {

//	ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
    private long id;
	
	@Column(name = "nome_usuario" , nullable = false, length = 45)
    private String nome;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contato", nullable = false)
    private Contato contato;

//	CONSTRUCTOR
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
