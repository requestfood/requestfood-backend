package br.senac.requestfood.dto.dish;

import br.senac.requestfood.enumeration.dish.CategoryDish;

public record DishDTO(Long id, Long idEstablishment, String name, String description, Byte[] image, Double price, CategoryDish categoryDish) {}
