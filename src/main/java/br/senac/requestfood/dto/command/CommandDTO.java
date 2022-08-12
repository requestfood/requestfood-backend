package br.senac.requestfood.dto.command;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.table.Desk;
import br.senac.requestfood.model.user.client.Client;

public record CommandDTO(Long id, Client client, Desk desk, LocalDateTime issueDate, LocalDateTime closingDate, List<Item> itens, Double value) {}
