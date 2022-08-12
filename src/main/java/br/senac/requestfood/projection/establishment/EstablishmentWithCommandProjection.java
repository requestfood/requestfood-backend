package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.order.CommandProjection;

public interface EstablishmentWithCommandProjection {

	Long getId();

	String getName();
	
	String getImage();
	
	String getCep();
	
	String getBiography();

	List<CommandProjection> getCommands();

}
