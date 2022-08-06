package br.senac.requestfood.exception.mesa;

public class TableNotFoundException extends RuntimeException{
	public TableNotFoundException(String message) {
		super(message);
	}
}
