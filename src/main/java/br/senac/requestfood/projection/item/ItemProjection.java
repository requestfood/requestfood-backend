package br.senac.requestfood.projection.item;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;

public interface ItemProjection {
	
	Comanda getBill();
	
	Integer getQuantity();

	Consumivel getProduct();
	
	String getDescription();

}
