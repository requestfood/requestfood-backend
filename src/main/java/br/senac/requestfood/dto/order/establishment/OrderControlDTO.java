package br.senac.requestfood.dto.order.establishment;

import java.util.List;

import br.senac.requestfood.dto.item.ItemDetailsDTO;

public record OrderControlDTO(Long idOrder, String name, String surname, Double amount, List<ItemDetailsDTO> items) {}
