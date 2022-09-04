package br.senac.requestfood.projection.establishment;

import br.senac.requestfood.model.contact.Contact;

public interface EstablishmentProjection {

	Long getId();

	String getName();
	
	Byte[] getImage();
	
	String getDescription();
	
	String getPassword();
	
	Contact getContact();
}
