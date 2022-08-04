package br.senac.requestfood.dto.contato;

import br.senac.requestfood.model.usuario.Usuario;

public record ContatoDTO(Long id, Usuario usuario, String telefone, String email) {}
