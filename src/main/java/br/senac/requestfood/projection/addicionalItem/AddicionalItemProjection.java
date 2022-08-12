package br.senac.requestfood.projection.addicionalItem;

import br.senac.requestfood.model.item.Item;

public interface AddicionalItemProjection {

	Long getId();
	
	Item getItem();
	
	String getName();
	
	Integer getQuantity();
}
