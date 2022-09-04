package br.senac.requestfood.dto.order;

import java.util.List;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

public record CreateOrderDTO(Long id, Establishment establishment, Client client, List<Item> items) {}
