package br.senac.requestfood.projection.estabelecimento;

import java.util.List;

import br.senac.requestfood.projection.mesa.MesaProjection;

public interface EstablishmentWithTableProjection {

	Long getId();

	String getName();

	List<MesaProjection> getTables();
}
