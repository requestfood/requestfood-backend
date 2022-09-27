package br.senac.requestfood.model.usuario.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.genero.Genero;
import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.usuario.Usuario;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "genero_cliente", nullable = false)
    private Genero genero;
	
	@Column(name = "data_nascimento_cliente", nullable = false)
    private LocalDate dataNascimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Comanda> comandas;
	
    public Cliente(Long id, String nome, Contato contato, Genero genero, LocalDate dataNascimento) {
        super(id, nome, contato);
        setGenero(genero);
        setDataNascimento(dataNascimento);
        comandas = new ArrayList<>();
    }
    
	public Cliente() {}

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