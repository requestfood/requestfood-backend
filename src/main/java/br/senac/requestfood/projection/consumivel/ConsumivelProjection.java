package br.senac.requestfood.projection.consumivel;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface ConsumivelProjection {

	Long getId();
	
	Estabelecimento getEstabelecimento();
	
	String getName();
	
	Float getValor();
	
	String getDescription();
	
	Byte[] getImage();
}
