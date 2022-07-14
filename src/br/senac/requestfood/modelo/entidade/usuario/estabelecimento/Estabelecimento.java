package br.senac.requestfood.modelo.entidade.usuario.estabelecimento;

import br.senac.requestfood.modelo.entidade.cardapio.Cardapio;
import br.senac.requestfood.modelo.entidade.contato.Contato;
import br.senac.requestfood.modelo.entidade.mesa.Mesa;
import br.senac.requestfood.modelo.entidade.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento extends Usuario {

    private Cardapio cardapio;
    private List<Mesa> mesas;

    public Estabelecimento(Cardapio cardapio, int id , String nome, Contato contato){
        super(id, nome, contato);
        setCardapio(cardapio);
        mesas = new ArrayList<>();
    }


    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
}
