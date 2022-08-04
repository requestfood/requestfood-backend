package br.senac.requestfood.dto.itemadicional;

import br.senac.requestfood.model.item.Item;

public record ItemAdicionalDTO(Long id, Item item, String nomeAdicional, Integer quantidade) {}
