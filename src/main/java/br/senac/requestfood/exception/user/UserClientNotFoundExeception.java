package br.senac.requestfood.exception.user;

public class UserClientNotFoundExeception extends RuntimeException{

    public UserClientNotFoundExeception(String message) {
        super(message);
    }
}
