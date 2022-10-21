package br.senac.requestfood.dto.order.establishment;

import java.time.LocalDateTime;

public record OrderReadyDTO(Long idOrder, String nameClient, LocalDateTime closingDate) {}
