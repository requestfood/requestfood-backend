package br.senac.requestfood.exception.order;

public class CommandNotFoundException extends RuntimeException {

	public CommandNotFoundException (String message) {
		super(message);
	}
}