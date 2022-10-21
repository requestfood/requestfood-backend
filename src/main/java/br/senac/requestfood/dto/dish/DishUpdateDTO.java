package br.senac.requestfood.dto.dish;

import br.senac.requestfood.enumeration.dish.CategoryDish;

public record DishUpdateDTO(Long id, String name, String description, Double price, CategoryDish categoryDish) {

}
