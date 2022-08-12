package br.senac.requestfood.projection.command;

import java.time.LocalDateTime;

import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

public interface CommandProjection {

	Long getId();
	
	Client getClient();

	LocalDateTime getIssueDate();
	
	Establishment getEstablishment();
	
}
