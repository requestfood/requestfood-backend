package br.senac.requestfood.projection.itemAdicional;

import br.senac.requestfood.model.item.Item;

public interface ItemAdicionalProjection {

	Item getItem();
	
	String getAdditionalName();
	
	Integer getQuantity();

	String getDescription();
}
