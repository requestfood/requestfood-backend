package br.senac.requestfood.dto.client;

import br.senac.requestfood.enumeration.gender.Gender;

public record ClientUpdateDTO(Long id, String name, String surname, Gender gender) {}
