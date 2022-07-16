package br.senac.requestfood.model.consumivel.bebida;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.tipobebida.TipoBebida;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public class Bebida extends Consumivel {

    private boolean alcoolico;
    private TipoBebida tipoBebida;

    public Bebida(long id, Estabelecimento estabelecimento, String nome, float valor, String descricao, Byte[] imagem, boolean alcoolico, TipoBebida tipoBebida){
        super(id, estabelecimento, nome, valor, descricao, imagem);
        setAlcoolico(alcoolico);
        setTipoBebida(tipoBebida);
    }

    public void setAlcoolico(boolean alcoolico) {
        this.alcoolico = alcoolico;
    }
    public boolean alcoolico (boolean alcoolico) {
        return alcoolico;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

}
