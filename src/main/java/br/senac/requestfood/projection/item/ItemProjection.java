package br.senac.requestfood.projection.item;

import java.util.List;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

public interface ItemProjection {
	
	Item getItem();
	
	Comanda getBill();
	
	Integer getQuantity();

	Consumivel getProduct();
	
	String getDescription();
	
	List<ItemAdicional> getItensAdicionais();

}
