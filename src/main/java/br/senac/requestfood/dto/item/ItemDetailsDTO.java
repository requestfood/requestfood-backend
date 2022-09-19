package br.senac.requestfood.dto.item;

public record ItemDetailsDTO(String nameConsumable, Double value, Integer quantity,
		String observation) {}
