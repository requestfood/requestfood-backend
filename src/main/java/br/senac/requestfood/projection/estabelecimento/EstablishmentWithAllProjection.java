package br.senac.requestfood.projection.estabelecimento;

import java.util.List;

import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.consumable.ConsumableProjection;
import br.senac.requestfood.projection.mesa.TableProjection;

public interface EstablishmentWithAllProjection {

	Long getId();

	String getName();

	List<TableProjection> getTables();

	List<ConsumableProjection> getConsumable();

	List<ComandaProjection> getBill();
}
