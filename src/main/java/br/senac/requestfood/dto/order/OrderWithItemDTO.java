package br.senac.requestfood.dto.order;

import java.util.List;

import br.senac.requestfood.dto.item.ItemOrderDTO;

public record OrderWithItemDTO(Long idEstablishment, Long idClient, List<ItemOrderDTO> items) {}
