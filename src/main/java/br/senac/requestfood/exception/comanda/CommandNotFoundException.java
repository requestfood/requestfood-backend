package br.senac.requestfood.exception.comanda;

public class CommandNotFoundException extends RuntimeException {

	public CommandNotFoundException (String message) {
		super(message);
	}
}