package org.example.bookstorespringboot.exception;

public class RoleNotFoundException extends IllegalStateException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}
