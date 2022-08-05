package br.senac.requestfood.projection.cliente;

import java.time.LocalDate;

import br.senac.requestfood.enumeration.genero.Genero;
import br.senac.requestfood.model.contato.Contato;

public interface ClienteProjection {

	Long getId();

	String getName();

	Contato getContact();

	String getPassword();

	Genero getGenero();
	
	LocalDate getDataNascimento();
	
}
