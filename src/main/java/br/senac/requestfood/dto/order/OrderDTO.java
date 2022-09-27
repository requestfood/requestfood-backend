package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;

import br.senac.requestfood.enumeration.order.OrderStatus;

public record OrderDTO(Long id, Long idEstablishment, Long idClient, 
			LocalDateTime issueDate, LocalDateTime closingDate, 
			OrderStatus orderStatus, Double amount) {}
