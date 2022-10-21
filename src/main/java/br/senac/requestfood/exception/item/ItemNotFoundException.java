package br.senac.requestfood.exception.item;

public class ItemNotFoundException extends RuntimeException{
	public ItemNotFoundException(String message) {
		super(message);
	}
}
