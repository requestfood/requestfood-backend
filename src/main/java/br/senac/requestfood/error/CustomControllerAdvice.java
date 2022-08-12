package br.senac.requestfood.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.client.ContactRegisteredException;
import br.senac.requestfood.exception.command.CommandClientNotFoundException;
import br.senac.requestfood.exception.command.CommandDeskRegisteredException;
import br.senac.requestfood.exception.command.CommandNotFoundException;
import br.senac.requestfood.exception.consumable.ConsumableNameRegisteredException;
import br.senac.requestfood.exception.consumable.ConsumableNotFoundException;
import br.senac.requestfood.exception.contact.ContactEmailRegisteredException;
import br.senac.requestfood.exception.contact.ContactNotFoundException;
import br.senac.requestfood.exception.contact.ContactPhoneRegisteredException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.exception.item.ItemNotFoundException;
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

    //Exceptions Command

    @ExceptionHandler(CommandDeskRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleComandaMesaRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    @ExceptionHandler(CommandClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCommandClientNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(CommandNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCommandNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    //Exceptions Consumable

    @ExceptionHandler(ConsumableNameRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleConsumivelNameRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ConsumableNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleConsumivelNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    //Exceptions Contact

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContactNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    @ExceptionHandler(ContactEmailRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContatoEmailRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ContactPhoneRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContatoTelefoneRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    //Exceptions Establishment

    @ExceptionHandler(EstablishmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEstablishmentNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    //Exceptions Item

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    //Exceptions User

    @ExceptionHandler(UserClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioClienteNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UserEstablishmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioEstabelecimentoNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(UserPasswordException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioPasswordException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }
}
