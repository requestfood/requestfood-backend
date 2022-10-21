package br.senac.requestfood.dto.order.establishment;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.order.OrderStatus;

public record OrderWithDateDTO(Long idOrder, String nameClient, OrderStatus status,LocalDateTime IssueDate, LocalDateTime closingDate) {}
