package br.senac.requestfood.projection.consumable;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface ConsumableProjection {

    Long getId();

    String getName();

    Estabelecimento getEstablishment();

    Float getValue();

    String getDescription();

    Byte[] getImage();

}
