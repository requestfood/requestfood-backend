package br.senac.requestfood.dto.order;

import java.time.LocalDateTime;

public record OrderReadyDTO(Long idOrder, String nameClient, LocalDateTime closingDate) {}
