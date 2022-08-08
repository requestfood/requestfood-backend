package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;

public interface ItemProjection {
	
	Long getId();
	
	Comanda getCommand();
	
	Integer getQuantity();

	Consumivel getConsumable();
	
	String getDescription();

}
