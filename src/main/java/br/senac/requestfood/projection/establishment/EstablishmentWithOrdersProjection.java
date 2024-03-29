package br.senac.requestfood.projection.establishment;

import java.util.List;

import br.senac.requestfood.projection.order.OrderProjection;

public interface EstablishmentWithOrdersProjection {

	Long getId();

	String getName();
	
	List<OrderProjection> getOrders();

}
