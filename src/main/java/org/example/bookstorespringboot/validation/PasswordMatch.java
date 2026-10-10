package org.example.bookstorespringboot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE_USE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {
    String message() default "Password does not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
