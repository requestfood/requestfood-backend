package br.senac.requestfood.dto.bebida;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public record BebidaDTO(Long id, String nome, Estabelecimento estabelecimento,Double valor) {}
