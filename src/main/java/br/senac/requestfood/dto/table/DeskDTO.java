package br.senac.requestfood.dto.table;

import java.util.List;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.user.establishment.Establishment;

public record DeskDTO(Long id, Establishment estabelecimento, String password ,Integer limitUserNumber, List<Command> comandas) {}
