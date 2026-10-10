package org.example.bookstorespringboot.service;

import org.example.bookstorespringboot.dto.UserRegistrationRequestDto;
import org.example.bookstorespringboot.dto.UserResponseDto;

public interface UserService {

    UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto);
}
