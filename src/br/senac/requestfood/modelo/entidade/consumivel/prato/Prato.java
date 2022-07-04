package br.senac.requestfood.modelo.entidade.consumivel.prato;

import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;
import br.senac.requestfood.modelo.enumeracao.tipoprato.TipoPrato;

import java.awt.*;

public class Prato extends Consumivel {
    private TipoPrato tipoPrato;

    public Prato(String nome, float valor, String descricao, Image imagem){
        super(nome, valor, descricao, imagem);
        setTipoPrato(tipoPrato);
    }

    public void setTipoPrato(TipoPrato tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    public TipoPrato getTipoPrato() {
        return tipoPrato;
    }
}
