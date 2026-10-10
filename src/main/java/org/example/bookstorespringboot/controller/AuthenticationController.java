package org.example.bookstorespringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.UserRegistrationRequestDto;
import org.example.bookstorespringboot.dto.UserResponseDto;
import org.example.bookstorespringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Management", description = "User management")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/registration")
    @Operation(summary = "User registration", description = "Register user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto request) {
        return userService.register(request);
    }
}
