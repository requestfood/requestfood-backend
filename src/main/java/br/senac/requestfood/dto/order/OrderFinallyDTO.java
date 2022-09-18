package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.order.OrderStatus;

public record OrderFinallyDTO( Long idOrder, Byte[] imageEstablishment, String nameEstablishment, OrderStatus  orderStatus, LocalDateTime issueDate ) {}
