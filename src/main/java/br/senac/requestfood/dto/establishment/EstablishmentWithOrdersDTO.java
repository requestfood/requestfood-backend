package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.dto.order.OrderDetailsDTO;

public record EstablishmentWithOrdersDTO(Long id, String name, List<OrderDetailsDTO> orders) {}
