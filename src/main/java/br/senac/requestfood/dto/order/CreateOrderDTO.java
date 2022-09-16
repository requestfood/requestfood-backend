package br.senac.requestfood.dto.order;

import java.util.List;

import br.senac.requestfood.model.item.Item;

public record CreateOrderDTO(Long id, Long idEstablishment, Long idClient, List<Item> items) {}
