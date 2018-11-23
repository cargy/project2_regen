package org.regeneration.exceptions;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String username){
        super("The username already exists.");
    }

}
