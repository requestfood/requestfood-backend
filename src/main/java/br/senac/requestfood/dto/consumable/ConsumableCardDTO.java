package br.senac.requestfood.dto.consumable;

public record ConsumableCardDTO(Long id, Byte[] image, Double price, String description) {}