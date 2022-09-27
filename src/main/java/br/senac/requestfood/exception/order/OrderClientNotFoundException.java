package br.senac.requestfood.exception.order;


public class OrderClientNotFoundException extends RuntimeException{

	public OrderClientNotFoundException(String message) {
		super(message);
	}
}
