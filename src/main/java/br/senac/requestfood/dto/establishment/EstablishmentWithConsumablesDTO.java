package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.model.consumable.Consumable;

public record EstablishmentWithConsumablesDTO(Long id, String name, List<Consumable> consumables) {}
