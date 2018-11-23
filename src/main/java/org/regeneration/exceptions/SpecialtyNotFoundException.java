package org.regeneration.exceptions;

public class SpecialtyNotFoundException extends RuntimeException {
    public SpecialtyNotFoundException(Long id) {
        super("Could not find specialty with id " + id);
    }
}
