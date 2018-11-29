package org.regeneration.exceptions;

public class CitizenNotFoundException extends RuntimeException {
    public CitizenNotFoundException(Long id) {
        super("Could not find citizen.");
    }
}
