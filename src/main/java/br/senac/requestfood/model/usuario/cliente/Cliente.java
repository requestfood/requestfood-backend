package br.senac.requestfood.model.usuario.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.genero.Genero;
import br.senac.requestfood.model.usuario.Usuario;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Cliente extends Usuario {

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "genero_cliente", nullable = false)
    private Genero genero;
	
	@Column(name = "data_nascimento_cliente", nullable = false)
    private LocalDate dataNascimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Comanda> comandas;
	
    public Cliente(long id, String nome, Contato contato, Genero genero, LocalDate dataNascimento) {
        super(id, nome, contato);
        setGenero(genero);
        setDataNascimento(dataNascimento);
        comandas = new ArrayList();
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void adicionarComanda(Comanda comanda){
        this.comandas.add(comanda);
    }
    public void removerComanda(Comanda comanda){
        this.comandas.remove(comanda);
    }
}
