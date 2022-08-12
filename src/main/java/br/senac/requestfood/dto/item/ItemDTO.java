package br.senac.requestfood.dto.item;

import br.senac.requestfood.model.order.Command;
import br.senac.requestfood.model.consumable.Consumable;

public record ItemDTO( Long id, Command command, Integer quanity, Consumable consumable, String observation) {}
