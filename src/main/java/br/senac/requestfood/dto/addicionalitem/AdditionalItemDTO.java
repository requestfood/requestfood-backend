package br.senac.requestfood.dto.addicionalitem;

import br.senac.requestfood.model.item.Item;

public record AdditionalItemDTO(Long id, Item item, String name, Integer quantity) {}
