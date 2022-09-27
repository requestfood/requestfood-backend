package br.senac.requestfood.exception.order;

public class OrderLimitDeleteDoNotCatchUpException extends RuntimeException{
	
	public OrderLimitDeleteDoNotCatchUpException(String message) {
		super(message);
	}

}
