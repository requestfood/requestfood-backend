package br.senac.requestfood.projection.cliente;

import java.time.LocalDate;

import br.senac.requestfood.enumeration.genero.Genero;

public interface ClienteProjection {

	String getNome();

	Genero getGenero();
	
	LocalDate getDataNascimento();
	
}
