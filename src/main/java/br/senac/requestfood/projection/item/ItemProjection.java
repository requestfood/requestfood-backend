package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.order.Order;

public interface ItemProjection {
	
	Long getId();
	
	Order getOrder();
	
	Integer getQuantity();

	Consumable getConsumable();
}
