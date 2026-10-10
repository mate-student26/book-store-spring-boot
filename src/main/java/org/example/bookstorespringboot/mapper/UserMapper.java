package org.example.bookstorespringboot.mapper;

import org.example.bookstorespringboot.config.MapperConfig;
import org.example.bookstorespringboot.dto.UserRegistrationRequestDto;
import org.example.bookstorespringboot.dto.UserResponseDto;
import org.example.bookstorespringboot.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto toResponse(User user);
}
