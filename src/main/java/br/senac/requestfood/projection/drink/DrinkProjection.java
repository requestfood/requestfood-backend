package br.senac.requestfood.projection.drink;

import br.senac.requestfood.enumeration.drink.CategoryDrink;

public interface DrinkProjection {

	Long getId();

	String getName();

	Double getPrice();

	String getDescription();

	CategoryDrink getCategoryDrink();
}
