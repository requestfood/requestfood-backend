package br.senac.requestfood.projection.estabelecimento;

import java.util.List;

import br.senac.requestfood.projection.comanda.ComandaProjection;
import br.senac.requestfood.projection.consumivel.ConsumivelProjection;
import br.senac.requestfood.projection.mesa.MesaProjection;

public interface EstabelecimentoProjection {

	List<MesaProjection> getTables();
	
	List<ConsumivelProjection> getConsumable();
	
	List<ComandaProjection> getBill();
	
}
