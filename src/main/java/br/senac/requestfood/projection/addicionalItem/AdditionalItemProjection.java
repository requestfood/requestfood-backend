package br.senac.requestfood.projection.addicionalItem;

import br.senac.requestfood.model.item.Item;

public interface AdditionalItemProjection {

	Long getId();
	
	Item getItem();
	
	String getName();
	
	Integer getQuantity();
}
