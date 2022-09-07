package br.senac.requestfood.dto.user;

import br.senac.requestfood.model.contact.Contact;

public record UserDTO(Long id, String name, Contact contact, String password) {}
