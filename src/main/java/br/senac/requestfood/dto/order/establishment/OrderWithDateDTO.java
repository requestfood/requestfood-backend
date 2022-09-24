package br.senac.requestfood.dto.order.establishment;

import java.time.LocalDateTime;

public record OrderWithDateDTO(Long idOrder, String nameClient, LocalDateTime IssueDate, LocalDateTime closingDate) {}
