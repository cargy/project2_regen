package org.regeneration.exceptions;

public class CitizenAppointmentConflictException extends RuntimeException {
    public CitizenAppointmentConflictException() {
        super("You have already an appointment at selected date/time!");
    }
}
