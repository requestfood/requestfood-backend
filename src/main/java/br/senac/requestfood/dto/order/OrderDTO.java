package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.enumeration.orderStatus.OrderStatus;
import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

public record OrderDTO(Long id, Establishment establishment, Client client, LocalDateTime issueDate, LocalDateTime closingDate, OrderStatus orderStatus, Double amount) {}
