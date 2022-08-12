package br.senac.requestfood.exception.user;

public class UserClientNotFoundException extends RuntimeException{

    public UserClientNotFoundException(String message) {
        super(message);
    }
}
