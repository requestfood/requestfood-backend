package br.senac.requestfood.dto.estabelecimento;

import java.util.List;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.mesa.Mesa;

public record EstabelecimentoDTO(Long id, String nome, List<Consumivel> consumiveis, List<Mesa> mesas) {}
