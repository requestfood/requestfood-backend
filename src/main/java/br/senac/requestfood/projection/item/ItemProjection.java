package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.consumable.Consumable;

public interface ItemProjection {
	
	Long getId();
	
	Command getCommand();
	
	Integer getQuantity();

	Consumable getConsumable();
	
	String getDescription();
}
