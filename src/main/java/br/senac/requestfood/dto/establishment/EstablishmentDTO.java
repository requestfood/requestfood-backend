package br.senac.requestfood.dto.establishment;

import br.senac.requestfood.model.contact.Contact;

public record EstablishmentDTO(Long id, String name, Contact contact, String password, Byte[] image, String cep,String description) {}