package br.senac.requestfood.dto.client;

import br.senac.requestfood.enumeration.gender.Gender;

public record ClientUpdateDTO(String name, String surname, Gender gender) {}
