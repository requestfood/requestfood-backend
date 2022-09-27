package br.senac.requestfood.projection.client;

import java.util.List;

import br.senac.requestfood.projection.order.OrderProjection;

public interface ClientWithOrdersProjection {

    Long getId();

    List<OrderProjection> getOrders();
}


 