package br.senac.requestfood.dto.establishment;

import java.time.LocalTime;

public record EstablishmentAllDTO(Long id, String name, String email, String phone, 
		String password, byte[] image, LocalTime timeToOpen, LocalTime timeToClose) {}