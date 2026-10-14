package org.example.bookstorespringboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

public class FieldMatchValidator
        implements ConstraintValidator<FieldMatch, Object> {

    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstField = constraintAnnotation.first();
        secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        try {
            Field first = value.getClass().getDeclaredField(firstField);
            Field second = value.getClass().getDeclaredField(secondField);

            first.setAccessible(true);
            second.setAccessible(true);

            Object firstValue = first.get(value);
            Object secondValue = second.get(value);

            return Objects.equals(firstValue, secondValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return false;
        }
    }
}
