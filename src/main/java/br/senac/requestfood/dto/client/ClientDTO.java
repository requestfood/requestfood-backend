package br.senac.requestfood.dto.client;

import br.senac.requestfood.model.contact.Contact;

public record ClientDTO(Long id,String name, Contact contact) {}
