package br.senac.requestfood.dto.establishment;

import java.util.List;

import br.senac.requestfood.dto.order.establishment.OrderWithDateDTO;

//Screen 10.8
public record EstablishmentWithOrdersDTO(Long id, String name, List<OrderWithDateDTO> orders) {}
