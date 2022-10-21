package br.senac.requestfood.dto.drink;

import br.senac.requestfood.enumeration.drink.CategoryDrink;

public record DrinkUpdateDTO(Long id, String name, Double price, String description, Boolean alcoholic, CategoryDrink categoryDrink) {

}
