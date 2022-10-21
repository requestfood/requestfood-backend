package br.senac.requestfood.projection.user;

import br.senac.requestfood.projection.contact.ContactProjection;

public interface UserProjection {

	Long getId();
	
	String getName();
	
	ContactProjection getContact();
	
	String getPassword();

}
