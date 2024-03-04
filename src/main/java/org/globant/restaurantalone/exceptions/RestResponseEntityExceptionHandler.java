package org.globant.restaurantalone.exceptions;

import org.globant.restaurantalone.exceptions.Client.ClientDataInvalidOrIncomplete;
import org.globant.restaurantalone.exceptions.Client.ClientDocumentAlreadyExists;
import org.globant.restaurantalone.exceptions.Client.ClientNotFound;
import org.globant.restaurantalone.exceptions.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The type Rest response entity exception handler.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Client not found exception response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler(ClientNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> clientNotFoundException() {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, "Client not found or does not exist.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    /**
     * Client with document already exists response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler(ClientDocumentAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessage> clientWithDocumentAlreadyExists() {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, "Client with that document already exists.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    /**
     * Client data invalid or incomplete response entity.
     *
     * @return the response entity
     */
    @ExceptionHandler(ClientDataInvalidOrIncomplete.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> clientDataInvalidOrIncomplete() {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "Client data is invalid or incomplete.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}