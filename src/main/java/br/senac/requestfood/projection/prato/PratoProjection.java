package br.senac.requestfood.projection.prato;

import br.senac.requestfood.enumeration.prato.CategoriaPrato;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface PratoProjection {

	Long getId();

	String getName();

	Estabelecimento getEstablishment();

	Float getValue();

	String getDescription();

	Byte[] getImage();

	CategoriaPrato getDishType();

}
