package br.senac.requestfood.projection.bebida;

import br.senac.requestfood.enumeration.bebida.CategoriaBebida;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public interface BebidaProjection {

	Long getId();

	String getName();

	Estabelecimento getEstablishment();

	Float getValue();

	String getDescription();

	Byte[] getImage();

	CategoriaBebida getDrinkType();

}
