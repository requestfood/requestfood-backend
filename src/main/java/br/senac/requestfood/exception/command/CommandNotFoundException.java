package br.senac.requestfood.exception.command;

public class CommandNotFoundException extends RuntimeException {

	public CommandNotFoundException (String message) {
		super(message);
	}
}