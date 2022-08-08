package br.senac.requestfood.dto.estabelecimento;

import java.util.List;

import br.senac.requestfood.model.consumivel.Consumivel;
import br.senac.requestfood.model.contato.Contato;
import br.senac.requestfood.model.mesa.Mesa;

public record EstabelecimentoDTO(Long id, String nome, Contato contato, List<Consumivel> consumiveis, List<Mesa> mesas) {}
