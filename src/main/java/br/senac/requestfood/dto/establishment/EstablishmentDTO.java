package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.model.consumable.Consumable;
import br.senac.requestfood.model.contact.Contact;

public record EstablishmentDTO(Long id, String name, Contact contact, List<Consumable> consumables) {}
