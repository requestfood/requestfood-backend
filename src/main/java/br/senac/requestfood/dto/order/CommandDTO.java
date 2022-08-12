package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.user.client.Client;

public record CommandDTO(Long id, Client client, LocalDateTime issueDate, LocalDateTime closingDate, List<Item> itens, Double value) {}
