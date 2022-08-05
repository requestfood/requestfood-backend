package br.senac.requestfood.projection.cliente;

import br.senac.requestfood.enumeration.genero.Genero;
import br.senac.requestfood.projection.comanda.ComandaProjection;

import java.time.LocalDate;
import java.util.List;

public interface ClienteProjectionWithComandas {

    Long getId();

    String getNome();

    Genero getGenero();

    LocalDate getDataNascimento();

    List<ComandaProjection> getComandas();
}
