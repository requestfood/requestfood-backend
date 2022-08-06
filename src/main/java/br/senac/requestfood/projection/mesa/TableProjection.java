package br.senac.requestfood.projection.mesa;

import java.util.List;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface TableProjection {

	Long getId();
	
	Estabelecimento getEstablishment();
	
	String getPassword();
	
	Integer getLimitUserNumber();
	
	List<Comanda> getComandas();
}
