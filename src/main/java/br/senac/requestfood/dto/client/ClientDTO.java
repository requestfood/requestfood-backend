package br.senac.requestfood.dto.client;

import java.time.LocalDate;

import br.senac.requestfood.enumeration.gender.Gender;
import br.senac.requestfood.model.contact.Contact;

public record ClientDTO(Long id, String name, Contact contact, String surname, Gender gender, LocalDate birthDate ) {}
