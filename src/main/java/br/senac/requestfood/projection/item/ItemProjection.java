package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.order.Order;
import br.senac.requestfood.model.consumable.Consumable;

public interface ItemProjection {
	
	Long getId();
	
	Order getOrder();
	
	Integer getQuantity();

	Consumable getConsumable();
	
	String getDescription();
}
