package br.senac.requestfood.projection.consumable;

import br.senac.requestfood.model.user.establishment.Establishment;

public interface ConsumableProjection {

    Long getId();

    String getName();

    Establishment getEstablishment();

    Float getValue();

    String getDescription();

    Byte[] getImage();

}
