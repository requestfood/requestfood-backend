package br.senac.requestfood.dto.consumable;

public record ConsumableCardDTO(Long id, Byte[] image, String name, Double price, String description) {}