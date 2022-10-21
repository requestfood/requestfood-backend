package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.dto.order.establishment.OrderReadyDTO;

public record EstablishmentWithOrdersReadyDTO(Long id, String name, List<OrderReadyDTO> ordersFinised) {}
