package br.senac.requestfood.projection.establishment;

import java.time.LocalTime;

public interface EstablishmentUpdateProjection {

	String getName();
	
	LocalTime getTimeToOpen();
	
	LocalTime getTimeToClose();
	
}
