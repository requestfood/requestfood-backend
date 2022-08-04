package br.senac.requestfood.dto.comanda;

import java.time.LocalDateTime;
import java.util.List;

import br.senac.requestfood.model.item.Item;
import br.senac.requestfood.model.mesa.Mesa;
import br.senac.requestfood.model.usuario.cliente.Cliente;

public record ComandaDTO(Long id, Cliente cliente, Mesa mesa, LocalDateTime dataEmissao, LocalDateTime dataFechamento, List<Item> itens) {}
