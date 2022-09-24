package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.order.OrderStatus;

public record OrderStartedDTO( Long idOrder, Byte[] imageEstablishment, String nameEstablishment, OrderStatus  orderStatus, LocalDateTime issueDate ) {}
