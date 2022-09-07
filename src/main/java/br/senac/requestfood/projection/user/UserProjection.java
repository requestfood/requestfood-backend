package br.senac.requestfood.projection.user;

import br.senac.requestfood.model.contact.Contact;

public interface UserProjection {

	Long getId();
	
	String getName();
	
	Contact getContact();
	
	String getPassword();

}
