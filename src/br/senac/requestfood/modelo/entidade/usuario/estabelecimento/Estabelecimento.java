package br.senac.requestfood.modelo.entidade.usuario.estabelecimento;

import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;
import br.senac.requestfood.modelo.entidade.contato.Contato;
import br.senac.requestfood.modelo.entidade.mesa.Mesa;
import br.senac.requestfood.modelo.entidade.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento extends Usuario {

    private List<Consumivel> consumiveis;
    private List<Mesa> mesas;

    public Estabelecimento(long id , String nome, Contato contato){
        super(id, nome, contato);
        mesas = new ArrayList<>();
        consumiveis = new ArrayList<>();
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }
}
