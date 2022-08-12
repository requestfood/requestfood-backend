package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.command.CommandProjection;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.projection.desk.DeskProjection;

public interface EstablishmentWithAllProjection {

	Long getId();

	String getName();

	List<DeskProjection> getDesks();

	List<ConsumableProjection> getConsumables();

	List<CommandProjection> getCommands();
}
