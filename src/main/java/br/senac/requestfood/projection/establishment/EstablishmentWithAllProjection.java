package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.order.CommandProjection;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface EstablishmentWithAllProjection {

	Long getId();

	String getName();
	
	String getImage();
	
	String getCep();
	
	String getBiography();

	List<ConsumableProjection> getConsumables();

	List<CommandProjection> getCommands();
}
