package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface EstablishmentWithConsumableProjection {

	Long getId();

	String getName();
	
	List<ConsumableProjection> getConsumables();
}
