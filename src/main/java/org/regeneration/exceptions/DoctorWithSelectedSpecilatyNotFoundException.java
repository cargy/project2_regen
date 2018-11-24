package org.regeneration.exceptions;

public class DoctorWithSelectedSpecilatyNotFoundException extends RuntimeException {
    public DoctorWithSelectedSpecilatyNotFoundException(String specialtyName) {
        super("Could not find doctors with specialty: " + specialtyName);
    }
}
