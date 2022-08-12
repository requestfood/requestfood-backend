package br.senac.requestfood.dto.dish;

import br.senac.requestfood.model.user.establishment.Establishment;

public record DishDTO(Long id, String name, Establishment establishment, Double value) {}
