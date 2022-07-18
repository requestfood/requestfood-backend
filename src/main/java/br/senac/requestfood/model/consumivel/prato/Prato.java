package br.senac.requestfood.model.consumivel.prato;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.tipoprato.TipoPrato;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

import javax.persistence.*;

@Entity
@Table(name="prato")
@PrimaryKeyJoinColumn(name = "id_consumivel")

public class Prato extends Consumivel {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_prato", nullable = false)
    private TipoPrato tipoPrato;

    public Prato(Long id, Estabelecimento estabelecimento, String nome, float valor, String descricao, Byte[] imagem, TipoPrato tipoPrato){
        super(id, estabelecimento, nome, valor, descricao, imagem);
        setTipoPrato(tipoPrato);
    }

    public void setTipoPrato(TipoPrato tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    public TipoPrato getTipoPrato() {
        return tipoPrato;
    }
}
