package br.senac.requestfood.projection.itemAdicional;

import br.senac.requestfood.model.item.Item;

public interface ItemAdicionalProjection {

	Long getId();
	
	Item getItem();
	
	String getName();
	
	Integer getQuantity();
}
