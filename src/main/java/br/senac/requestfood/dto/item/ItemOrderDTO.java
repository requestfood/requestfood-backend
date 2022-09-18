package br.senac.requestfood.dto.item;

public record ItemOrderDTO(Long id, Long idOrder, Long idConsumable, Integer quantityItem, String obsItem) {}
