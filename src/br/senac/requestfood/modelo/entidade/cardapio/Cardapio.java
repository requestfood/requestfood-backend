package br.senac.requestfood.modelo.entidade.cardapio;

import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;
import br.senac.requestfood.modelo.entidade.usuario.restaurante.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private Restaurante restaurante;
    private List<Consumivel> consumiveis;

    public Cardapio (Restaurante restaurante){
        setRestaurante(restaurante);
        consumiveis = new ArrayList<>();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }

}

