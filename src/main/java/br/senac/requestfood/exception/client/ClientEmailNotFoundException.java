package br.senac.requestfood.exception.client;

public class ClientEmailNotFoundException extends RuntimeException {
	
	public ClientEmailNotFoundException(String message) {
		super(message);
	}
}