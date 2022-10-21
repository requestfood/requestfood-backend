package br.senac.requestfood.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.senac.requestfood.exception.client.ClientEmailNotFoundException;
import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.client.ContactRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.exception.establishment.EstablishmentEmailNotFoundException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.exception.item.ItemNotFoundException;
import br.senac.requestfood.exception.order.OrderClientNotFoundException;
import br.senac.requestfood.exception.order.OrderLimitDeleteDoNotCatchUpException;
import br.senac.requestfood.exception.order.OrderNotFoundException;
import br.senac.requestfood.exception.user.UserClientNotFoundException;
import br.senac.requestfood.exception.user.UserEstablishmentNotFoundException;
import br.senac.requestfood.exception.user.UserNotFoundException;
import br.senac.requestfood.exception.user.UserPasswordException;

public class CustomControllerAdvice {

    //Exceptions Client

    @ExceptionHandler(ContactRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactRegisteredException(Exception exception) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(Exception exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(ClientEmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientEmailNotFoundException(Exception exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    //Exceptions Order

    @ExceptionHandler(OrderClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderClientNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }
    @ExceptionHandler(OrderLimitDeleteDoNotCatchUpException.class)
    public ResponseEntity<ErrorResponse> handleOrderLimitDeleteDoNotCatchUpException(Exception exception) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }
    //Exceptions Consumable

    @ExceptionHandler(ConsumableNameRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleConsumableNameRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ConsumableNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleConsumableNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    //Exceptions Contact

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContactNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    @ExceptionHandler(ContactEmailRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactEmailRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ContactPhoneRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContactPhoneRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    //Exceptions Establishment

    @ExceptionHandler(EstablishmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEstablishmentNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }
    @ExceptionHandler(EstablishmentEmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEstablishmentEmailNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }    

    //Exceptions Item

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    //Exceptions User

    @ExceptionHandler(UserClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserClientNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UserEstablishmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserEstablishmentNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(UserPasswordException.class)
    public ResponseEntity<ErrorResponse> handleUserPasswordException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }
}
