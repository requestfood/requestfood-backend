package br.senac.requestfood.projection.consumable;

import br.senac.requestfood.model.user.establishment.Establishment;

public interface ConsumableProjection {

    Long getId();

    Establishment getEstablishment();

    String getName();

    Double getPrice();

    String getDescription();

    Byte[] getImage();

}
