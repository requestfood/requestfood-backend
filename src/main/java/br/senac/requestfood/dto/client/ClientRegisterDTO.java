package br.senac.requestfood.dto.client;

import java.time.LocalDate;

import br.senac.requestfood.enumeration.gender.Gender;

public record ClientRegisterDTO(Long id, String name, String phone, String email, 
		String password, String surname, Gender gender, 
		LocalDate birthDate) {}
