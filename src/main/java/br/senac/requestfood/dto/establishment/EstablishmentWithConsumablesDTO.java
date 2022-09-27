package br.senac.requestfood.dto.establishment;

import org.springframework.data.domain.Page;

import br.senac.requestfood.projection.consumable.ConsumableCardProjection;

public record EstablishmentWithConsumablesDTO(Long id, String name, Page<ConsumableCardProjection> consumables) {}
