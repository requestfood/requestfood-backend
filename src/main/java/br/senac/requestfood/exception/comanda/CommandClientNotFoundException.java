package br.senac.requestfood.exception.comanda;


public class CommandClientNotFoundException extends RuntimeException{

	public CommandClientNotFoundException (String message) {
		super(message);
	}
}
