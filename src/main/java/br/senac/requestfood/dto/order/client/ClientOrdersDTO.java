package br.senac.requestfood.dto.order.client;

import java.util.List;

public record ClientOrdersDTO(Long idClient ,List<OrderToClientDTO> ordersClient) {}
