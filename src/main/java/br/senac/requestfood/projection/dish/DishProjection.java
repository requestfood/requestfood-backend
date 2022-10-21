package br.senac.requestfood.projection.dish;

import br.senac.requestfood.enumeration.dish.CategoryDish;

public interface DishProjection {

	Long getId();

	String getName();

	Double getPrice();

	String getDescription();

	CategoryDish getCategoryDish();

}
