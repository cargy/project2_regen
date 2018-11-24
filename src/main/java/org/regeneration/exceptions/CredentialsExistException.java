package org.regeneration.exceptions;

public class CredentialsExistException extends RuntimeException {

    public CredentialsExistException(String username, String email, String phone, String ssn) {
        super("One or more of your credentials (" + username + ", " + email + ", " + phone + ", " + ssn + ") already exist.");
    }

}
