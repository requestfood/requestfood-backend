package br.senac.requestfood.model.mesa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Entity
@Table(name = "mesa")
public class Mesa {

   	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(name = "mesa_disponivel")
    private boolean disponivel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mesa", cascade = CascadeType.PERSIST)
    private List<Comanda> comandas;

    public Mesa() {}
     
    public Mesa(Long id, Estabelecimento estabelecimento, boolean disponivelMesa) {
        setId(id);
        setEstabelecimento(estabelecimento);
        setDisponivelMesa(disponivelMesa);
        comandas = new ArrayList<>();
    }

    public boolean equals(Object objeto) {

        if (this == objeto)
            return true;

        if (objeto == null)
            return false;

        if (getClass() != objeto.getClass())
            return false;

        Mesa mesa = ((Mesa) objeto);

        return this.getEstabelecimento() == mesa.getEstabelecimento() && this.getId() == this.getId() && this.getDisponivel() == mesa.getDisponivel() && this.getComandas() == mesa.getComandas();
    }
        
    
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setDisponivelMesa(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public boolean getDisponivel() {
        return disponivel;
    }
    
    public List<Comanda> getComandas() {
        return comandas;
    }
    
    public void adicionarComanda(Comanda comanda) {
    	comandas.add(comanda);
    }
    
    public void removerComanda(Comanda comanda) {
    	comandas.remove(comanda);
    }
}