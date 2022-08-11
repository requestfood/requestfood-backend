package br.senac.requestfood.error;

import br.senac.requestfood.exception.client.ClientNotFoundException;
import br.senac.requestfood.exception.client.ContactRegisteredExeception;
import br.senac.requestfood.exception.comanda.ComandaMesaRegisteredException;
import br.senac.requestfood.exception.comanda.CommandClientNotFoundException;
import br.senac.requestfood.exception.comanda.CommandNotFoundException;
import br.senac.requestfood.exception.consumivel.ConsumivelNameRegisteredException;
import br.senac.requestfood.exception.consumivel.ConsumivelNotFoundException;
import br.senac.requestfood.exception.contato.ContactNotFoundException;
import br.senac.requestfood.exception.contato.ContatoEmailRegisteredException;
import br.senac.requestfood.exception.contato.ContatoTelefoneRegisteredException;
import br.senac.requestfood.exception.establishment.EstablishmentNotFoundException;
import br.senac.requestfood.exception.item.ItemNotFoundException;
import br.senac.requestfood.exception.itemadicional.AdditionalItemNotFoundException;
import br.senac.requestfood.exception.itemadicional.ItemAdicionalNomeRegisteredException;
import br.senac.requestfood.exception.mesa.TableNotFoundException;
import br.senac.requestfood.exception.usuario.UsuarioClienteNotFoundExeception;
import br.senac.requestfood.exception.usuario.UsuarioEstabelecimentoNotFoundExeception;
import br.senac.requestfood.exception.usuario.UsuarioNotFoundException;
import br.senac.requestfood.exception.usuario.UsuarioPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Table;

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

    //Exceptions Comanda

    @ExceptionHandler(ComandaMesaRegisteredException.class)
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

    @ExceptionHandler(ConsumivelNameRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleConsumivelNameRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ConsumivelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleConsumivelNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    //Exceptions Contact

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContactNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    @ExceptionHandler(ContatoEmailRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleContatoEmailRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));

    }
    @ExceptionHandler(ContatoTelefoneRegisteredException.class)
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

    //Exceptions AdditionalItem

    @ExceptionHandler(AdditionalItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAdditionalItemNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));

    }

    @ExceptionHandler(ItemAdicionalNomeRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleItemAdicionalNomeRegisteredException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }

    //Exceptions Table

    @ExceptionHandler(TableNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTableNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    //Exceptions User

    @ExceptionHandler(UsuarioClienteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioClienteNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UsuarioEstabelecimentoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioEstabelecimentoNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNotFoundException(Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
    @ExceptionHandler(UsuarioPasswordException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioPasswordException(Exception exception){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
    }
}
