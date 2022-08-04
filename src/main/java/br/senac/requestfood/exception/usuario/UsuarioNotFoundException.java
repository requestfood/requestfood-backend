package br.senac.requestfood.exception.usuario;

public class UsuarioNotFoundException extends RuntimeException{
	public UsuarioNotFoundException(String message) {
		super(message);
	}
}
