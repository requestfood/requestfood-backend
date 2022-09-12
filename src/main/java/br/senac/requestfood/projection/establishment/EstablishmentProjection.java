package br.senac.requestfood.projection.establishment;

import java.time.LocalTime;

import br.senac.requestfood.model.contact.Contact;

public interface EstablishmentProjection {

	Long getId();

	String getName();
	
	Byte[] getImage();
		
	String getPassword();
	
	Contact getContact();
	
	LocalTime getTimeToOpen();
	
	LocalTime getTimeToClose();
}
