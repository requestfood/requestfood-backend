package br.senac.requestfood.dto.prato;

import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public record PratoDTO(Long id, String nome, Estabelecimento estabelecimento ,Double valor) {}
