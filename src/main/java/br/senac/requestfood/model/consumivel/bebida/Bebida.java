package br.senac.requestfood.model.consumivel.bebida;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.bebida.CategoriaBebida;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Entity
@Table(name = "bebida")
public class Bebida extends Consumivel {

	@Column(name = "alcoolico_bebida", nullable = false)
    private boolean alcoolico;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_bebida", nullable = false)
    private CategoriaBebida tipoBebida;

    public Bebida() {}

    public Bebida(Long id, Estabelecimento estabelecimento, String nome, float valor, String descricao, Byte[] imagem, boolean alcoolico, CategoriaBebida tipoBebida){
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

    public void setTipoBebida(CategoriaBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
    public CategoriaBebida getTipoBebida() {
        return tipoBebida;
    }
}