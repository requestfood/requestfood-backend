package br.senac.requestfood.model.consumivel.prato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.senac.requestfood.enumeration.prato.CategoriaPrato;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

@Entity
@Table(name="prato")
public class Prato extends Consumivel {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_prato", nullable = false)
    private CategoriaPrato tipoPrato;

    public Prato() {}

    public Prato(Long id, Estabelecimento estabelecimento, String nome, Double valor, String descricao, Byte[] imagem, CategoriaPrato tipoPrato){
        super(id, estabelecimento, nome, valor, descricao, imagem);
        setTipoPrato(tipoPrato);
    }

    public void setTipoPrato(CategoriaPrato tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    public CategoriaPrato getTipoPrato() {
        return tipoPrato;
    }
}