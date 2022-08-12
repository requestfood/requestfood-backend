package br.senac.requestfood.exception.command;


public class CommandClientNotFoundException extends RuntimeException{

	public CommandClientNotFoundException (String message) {
		super(message);
	}
}
