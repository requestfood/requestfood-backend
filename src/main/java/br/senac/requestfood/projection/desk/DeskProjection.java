package br.senac.requestfood.projection.desk;

import java.util.List;

import br.senac.requestfood.model.command.Command;
import br.senac.requestfood.model.user.establishment.Establishment;

public interface DeskProjection {

	Long getId();
	
	Establishment getEstablishment();
	
	String getPassword();
	
	Integer getLimitUserNumber();
	
	List<Command> getComandas();
}
