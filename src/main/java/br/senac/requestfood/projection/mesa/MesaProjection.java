package br.senac.requestfood.projection.mesa;

import java.util.List;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;
import br.senac.requestfood.projection.comanda.ComandaProjection;

public interface MesaProjection {

	Long getId();
	
	Estabelecimento getEstabelecimento();
	
	String getPassword();
	
	Integer getLimitUserNumber();
		
	List<ComandaProjection> getComandas();
}
