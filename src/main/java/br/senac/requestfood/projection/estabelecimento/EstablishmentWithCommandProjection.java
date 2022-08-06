package br.senac.requestfood.projection.estabelecimento;

import java.util.List;

import br.senac.requestfood.projection.comanda.ComandaProjection;

public interface EstablishmentWithCommandProjection {

	Long getId();

	String getName();

	List<ComandaProjection> getBill();

}
