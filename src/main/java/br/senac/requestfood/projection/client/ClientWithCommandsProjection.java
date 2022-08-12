package br.senac.requestfood.projection.client;

import br.senac.requestfood.enumeration.gender.Gender;
import br.senac.requestfood.projection.command.CommandProjection;

import java.time.LocalDate;
import java.util.List;

public interface ClientWithCommandsProjection {

    Long getId();

    String getNome();

    Gender getGenero();

    LocalDate getDataNascimento();

    List<CommandProjection> getComandas();
}
