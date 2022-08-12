package br.senac.requestfood.projection.client;

import java.time.LocalDate;

import br.senac.requestfood.enumeration.gender.Gender;
import br.senac.requestfood.model.contact.Contact;

public interface ClientProjection {

	Long getId();

	String getName();

	Contact getContact();

	String getPassword();

	Gender getGenero();
	
	LocalDate getDataNascimento();
	
}
