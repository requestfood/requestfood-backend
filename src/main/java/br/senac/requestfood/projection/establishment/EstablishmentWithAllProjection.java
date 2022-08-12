package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.command.CommandProjection;
import br.senac.requestfood.projection.consumable.ConsumableProjection;

public interface EstablishmentWithAllProjection {

	Long getId();

	String getName();

	List<ConsumableProjection> getConsumables();

	List<CommandProjection> getCommands();
}
