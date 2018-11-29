package org.regeneration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CitizenAppointmentConflictAdvice {
    @ResponseBody
    @ExceptionHandler(CitizenAppointmentConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String citizenNotFoundHandler(CitizenAppointmentConflictException ex) {
        return ex.getMessage();
    }

}

