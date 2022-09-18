package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.dto.item.ItemDetailsDTO;

public record OrderDetailsDTO(Long idOrder, Long idEstablishment,
		LocalDateTime issueDate, List<ItemDetailsDTO> items,
		Double amount) {}
