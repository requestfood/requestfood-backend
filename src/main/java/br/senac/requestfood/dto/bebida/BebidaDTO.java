package br.senac.requestfood.dto.bebida;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public record BebidaDTO(Long id, Estabelecimento estabelecimento, String nome, Double valor) {}
