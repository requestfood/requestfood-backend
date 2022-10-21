package br.senac.requestfood.dto.item;

public record ItemDetailsDTO(Long idItem,String nameConsumable, Double value, Integer quantity,
		String observation) {}
