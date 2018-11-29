package org.regeneration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class AppointmentInPastAdvice {
    @ResponseBody
    @ExceptionHandler(AppointmentInPastException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String appointmentInPastHandler(AppointmentInPastException ex) {
        return ex.getMessage();
    }
}


