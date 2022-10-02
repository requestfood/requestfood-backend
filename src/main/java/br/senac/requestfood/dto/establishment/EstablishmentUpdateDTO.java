package br.senac.requestfood.dto.establishment;

import java.time.LocalTime;

public record EstablishmentUpdateDTO(String name, Byte[] image, LocalTime timeToOpen, LocalTime timeToClose) {

}
