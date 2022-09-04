package br.senac.requestfood.dto.establishment;

public record EstablishmentAllDTO(Long id, String name, String email, String phone, String password, String description, Byte[] image) {}