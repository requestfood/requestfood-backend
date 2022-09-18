package br.senac.requestfood.dto.drink;

import br.senac.requestfood.enumeration.drink.CategoryDrink;
import br.senac.requestfood.model.user.establishment.Establishment;

public record DrinkDTO(Long id, String name, Long idEstablishment ,Double price, String description, Byte[] image, Boolean alcoholic, CategoryDrink categoryDrink) {}
