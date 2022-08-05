package br.senac.requestfood.dto.cliente;

import br.senac.requestfood.model.contato.Contato;

public record ClienteDTO(Long id,String nome, Contato contato) {}
