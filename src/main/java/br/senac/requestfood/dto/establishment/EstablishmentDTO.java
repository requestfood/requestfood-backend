package br.senac.requestfood.dto.establishment;

import java.time.LocalTime;

import br.senac.requestfood.model.contact.Contact;

public record EstablishmentDTO(Long id, String name, Contact contact, Byte[] image, LocalTime timeToOpen, LocalTime timeToClose) {}