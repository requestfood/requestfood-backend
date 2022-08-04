package br.senac.requestfood.exception.mesa;

public class MesaNotFoundException extends RuntimeException{
	public MesaNotFoundException(String message) {
		super(message);
	}
}
