package org.regeneration.exceptions;

public class AppointmentInPastException extends RuntimeException {
    public AppointmentInPastException() {super("Could not create appointment in the past.");
    }
}
