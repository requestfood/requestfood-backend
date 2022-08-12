package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.desk.DeskProjection;

public interface EstablishmentWithTableProjection {

	Long getId();

	String getName();

	List<DeskProjection> getDesks();
}
