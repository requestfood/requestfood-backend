package br.senac.requestfood.exception.order;


public class CommandClientNotFoundException extends RuntimeException{

	public CommandClientNotFoundException (String message) {
		super(message);
	}
}
