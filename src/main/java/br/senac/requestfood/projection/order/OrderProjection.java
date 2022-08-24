package br.senac.requestfood.projection.order;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.orderStatus.OrderStatus;
import br.senac.requestfood.model.user.client.Client;
import br.senac.requestfood.model.user.establishment.Establishment;

public interface OrderProjection {

	Long getId();
	
	Establishment getEstablishment();
	
	Client getClient();

	LocalDateTime getIssueDate();
	
	LocalDateTime getClosingDate();
	
	OrderStatus getOrderStatus();
}
