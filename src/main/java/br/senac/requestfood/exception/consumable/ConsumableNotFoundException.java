package br.senac.requestfood.exception.consumable;

public class ConsumableNotFoundException extends RuntimeException{
	public ConsumableNotFoundException(String message) {
		super(message);
	}
}
