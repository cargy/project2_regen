package org.regeneration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CredentialsExistAdvice {

    @ResponseBody
    @ExceptionHandler(CredentialsExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String usernameExistsHandler(CredentialsExistException ex) {
        return ex.getMessage();
    }

}
