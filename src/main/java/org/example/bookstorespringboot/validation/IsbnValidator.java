package org.example.bookstorespringboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsbnValidator implements ConstraintValidator<Isbn, String> {

    private static final String ISBN_13_REGEX = "^97[89]\\d{10}$";

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {

        if (isbn == null || isbn.isEmpty()) {
            return true;
        }

        isbn = isbn.replaceAll("[\\s-]", "");

        return isbn.matches(ISBN_13_REGEX);
    }
}
