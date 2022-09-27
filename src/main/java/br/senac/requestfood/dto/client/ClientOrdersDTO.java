package br.senac.requestfood.dto.client;

import java.util.List;

import br.senac.requestfood.dto.order.client.OrderToClientDTO;

public record ClientOrdersDTO(Long idClient ,List<OrderToClientDTO> ordersClient) {}
