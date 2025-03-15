package com.jvictornascimento.msuser.services.exceptions;

public class EmailNotFound extends RuntimeException {
    public EmailNotFound(String email) {
        super("Email: " + email + " not found");
    }
}
