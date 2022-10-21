package br.senac.requestfood.exception.order;

public class OrderAlreadyStartedException extends RuntimeException{

	public OrderAlreadyStartedException(String message) {
		super(message);
	}
}
