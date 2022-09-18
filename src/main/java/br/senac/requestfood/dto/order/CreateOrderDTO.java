package br.senac.requestfood.dto.order;

import java.util.List;

import br.senac.requestfood.dto.item.ItemOrderDTO;

public record CreateOrderDTO(Long id, Long idEstablishment, Long idClient, List<ItemOrderDTO> itemsOrder) {}
