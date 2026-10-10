package org.example.bookstorespringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.bookstorespringboot.validation.PasswordMatch;

@Data
@PasswordMatch(message = "Password does not match")
public class UserRegistrationRequestDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;

    private String shippingAddress;

    @NotNull
    @Size(min = 8, message = "Password must contain at least 8 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).*$",
            message = "Password must contain at least "
                    + "one uppercase letter and one special character"
    )
    private String password;

    @NotNull
    private String repeatPassword;
}
