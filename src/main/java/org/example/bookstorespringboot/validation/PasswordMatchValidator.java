package org.example.bookstorespringboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.bookstorespringboot.dto.UserRegistrationRequestDto;

public class PasswordMatchValidator
        implements ConstraintValidator<
        PasswordMatch, UserRegistrationRequestDto> {

    @Override
    public boolean isValid(UserRegistrationRequestDto dto, ConstraintValidatorContext context) {

        if (dto == null) {
            return true;
        }

        return dto.getPassword() != null
                && dto.getPassword().equals(dto.getRepeatPassword());
    }
}
