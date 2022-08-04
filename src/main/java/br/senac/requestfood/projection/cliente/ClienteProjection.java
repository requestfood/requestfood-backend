package br.senac.requestfood.projection.cliente;

import br.senac.requestfood.projection.comanda.ComandaProjection;

import java.time.LocalDate;
import java.util.List;

import br.senac.requestfood.enumeration.genero.Genero;

public interface ClienteProjection {

	Genero getGenero();
	
	LocalDate getDataNascimento();
	
	List<ComandaProjection> getComandas();
	
}
