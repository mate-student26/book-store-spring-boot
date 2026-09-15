package org.example.bookstorespringboot.exception;

public class NoParamsChosenException extends RuntimeException {
    public NoParamsChosenException(String message) {
        super(message);
    }
}
