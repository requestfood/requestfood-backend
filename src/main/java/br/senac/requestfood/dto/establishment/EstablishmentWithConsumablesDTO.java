package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.dto.consumable.ConsumableCardDTO;

public record EstablishmentWithConsumablesDTO(Long id, String name, List<ConsumableCardDTO> consumables) {}
