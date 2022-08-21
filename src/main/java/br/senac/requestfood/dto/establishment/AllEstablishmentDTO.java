package br.senac.requestfood.dto.establishment;

public record AllEstablishmentDTO(Long id, String name, String cep, String email, String phone, String password, String description, Byte[] image) {}