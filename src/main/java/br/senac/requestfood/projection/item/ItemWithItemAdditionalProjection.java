package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

import java.util.List;

public interface ItemWithItemAdditionalProjection {

    Item getItem();

    Comanda getBill();

    Integer getQuantity();

    Consumivel getProduct();

    String getDescription();

    List<ItemAdicional> getAdditionalItem();
}
