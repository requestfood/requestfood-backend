package br.senac.requestfood.dto.order.client;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.order.OrderStatus;

//Screen 9
public record OrderToClientDTO( Long idOrder, Long idEstablishment, byte[] imageEstablishment, String nameEstablishment, OrderStatus  orderStatus, LocalDateTime issueDate ) {}
