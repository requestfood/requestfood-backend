package br.senac.requestfood.projection.estabelecimento;

import java.util.List;

import br.senac.requestfood.projection.mesa.TableProjection;

public interface EstablishmentWithTableProjection {

	Long getId();

	String getName();

	List<TableProjection> getTables();
}
