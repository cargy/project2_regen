package org.regeneration.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(Long doctorId) {
        super("Couldn't find doctor with id: " + doctorId);
    }
}
