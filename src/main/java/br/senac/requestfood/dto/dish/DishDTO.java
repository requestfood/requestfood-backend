package br.senac.requestfood.dto.dish;

import br.senac.requestfood.enumeration.dish.CategoryDish;
import br.senac.requestfood.model.user.establishment.Establishment;

public record DishDTO(Long id, Establishment establishment, String name, String description, Byte[] image, Double price, CategoryDish typeDish) {}
