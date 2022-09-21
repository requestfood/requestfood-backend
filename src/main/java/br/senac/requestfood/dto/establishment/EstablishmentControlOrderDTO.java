package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.dto.item.ItemDetailsDTO;

public record EstablishmentControlOrderDTO(Long idOrder, String nomeCient, Double amount, List<ItemDetailsDTO> items) {}
