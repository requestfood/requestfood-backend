package br.senac.requestfood.projection.drink;

import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.model.user.establishment.Establishment;

public interface DrinkProjection {

	Long getId();

	String getName();

	Establishment getEstablishment();

	Double getValue();

	String getDescription();

	Byte[] getImage();

	CategoryDrink getDrinkType();
}