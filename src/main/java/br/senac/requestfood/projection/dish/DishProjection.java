package br.senac.requestfood.projection.dish;

import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.model.user.establishment.Establishment;

public interface DishProjection {

	Long getId();

	String getName();

	Establishment getEstablishment();

	Double getPrice();

	String getDescription();

	Byte[] getImage();

	CategoryDish getTypeDish();

}
