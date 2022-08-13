package br.senac.requestfood.projection.client;

import java.time.LocalDate;
import java.util.List;

import br.senac.requestfood.enumeration.gender.Gender;
import br.senac.requestfood.projection.order.OrderProjection;

public interface ClientWithOrdersProjection {

    Long getId();

    String getName();

    Gender getGender();

    LocalDate getBirthDate();

    List<OrderProjection> getOrders();
}
