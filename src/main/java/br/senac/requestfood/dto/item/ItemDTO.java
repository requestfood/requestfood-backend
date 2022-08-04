package br.senac.requestfood.dto.item;

import java.util.List;

import br.senac.requestfood.model.comanda.Comanda;
import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.itemadicional.ItemAdicional;

public record ItemDTO( Long id, Comanda comanda, Integer quantidade, Consumivel consumivel, String observacao, List<ItemAdicional> itensAdicionais) {}
