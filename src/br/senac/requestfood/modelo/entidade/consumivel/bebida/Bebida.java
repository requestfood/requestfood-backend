package br.senac.requestfood.modelo.entidade.consumivel.bebida;

import java.awt.Image;
import br.senac.requestfood.modelo.entidade.consumivel.Consumivel;
import br.senac.requestfood.modelo.enumeracao.tipobebida.TipoBebida;

public class Bebida extends Consumivel{

    private boolean alcoolico;
    private TipoBebida tipoBebida;

    public Bebida(String nome, float valor, String descricao, Image imagem,boolean alcoolico, TipoBebida tipoBebida){
       super(nome, valor, descricao, imagem);

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

	
}
