package br.senac.requestfood.dto.bebida;

import br.senac.requestfood.enumeration.bebida.CategoriaBebida;
import br.senac.requestfood.model.usuario.estabelecimento.Estabelecimento;

public record BebidaDTO(Long id, Estabelecimento estabelecimento, String nome, Double valor, String descricao, Byte[] imagem, Boolean alcoolico, CategoriaBebida tipoBebida) {}
