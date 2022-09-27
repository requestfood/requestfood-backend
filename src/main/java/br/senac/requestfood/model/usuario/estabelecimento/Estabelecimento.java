package br.senac.requestfood.model.usuario.estabelecimento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.Usuario;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento extends Usuario {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumivel> consumiveis;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mesa> mesas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estabelecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comanda> comandas;

    public Estabelecimento() {}

    public Estabelecimento(Long id , String nome, Contato contato){
        super(id, nome, contato);
        mesas = new ArrayList<>();
        consumiveis = new ArrayList<>();
        comandas = new ArrayList<>();
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }
    public List<Comanda> getComandas() {
        return comandas;
    }

    public void adicionarMesa(Mesa mesa) {
    	mesas.add(mesa);
    }
    
    public void removerMesa(Mesa mesa) {
    	mesas.remove(mesa);
    }
    
    public void adicionarConsumivel(Consumivel consumivel) {
    	consumiveis.add(consumivel);
    }
    
    public void removerConsumivel(Consumivel consumivel) {
    	consumiveis.remove(consumivel);
    }
}