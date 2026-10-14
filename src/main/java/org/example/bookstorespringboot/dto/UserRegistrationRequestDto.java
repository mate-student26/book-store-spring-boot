package org.example.bookstorespringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.bookstorespringboot.validation.FieldMatch;

@Data
@FieldMatch(first = "password",
            second = "repeatPassword",
            message = "Password does not match")
public class UserRegistrationRequestDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    private String shippingAddress;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;
}
