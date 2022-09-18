package br.senac.requestfood.dto.order;

import java.util.List;

public record OrderByClientDTO(List<OrderFinallyDTO> ordersClient) {}
