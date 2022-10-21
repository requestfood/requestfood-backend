package br.senac.requestfood.dto.order.client;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.dto.item.ItemDetailsDTO;

//Screen 9.1
public record OrderDetailsDTO(Long idOrder, String nameEstablishment,
		LocalDateTime issueDate, List<ItemDetailsDTO> items,
		Double amount) {}
