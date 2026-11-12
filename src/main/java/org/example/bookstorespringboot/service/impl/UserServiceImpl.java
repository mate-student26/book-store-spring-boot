package org.example.bookstorespringboot.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.UserRegistrationRequestDto;
import org.example.bookstorespringboot.dto.UserResponseDto;
import org.example.bookstorespringboot.exception.RegistrationException;
import org.example.bookstorespringboot.mapper.UserMapper;
import org.example.bookstorespringboot.model.Role;
import org.example.bookstorespringboot.model.User;
import org.example.bookstorespringboot.repository.RoleRepository;
import org.example.bookstorespringboot.repository.UserRepository;
import org.example.bookstorespringboot.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto) {

        if (userRepository.existsByEmail(userRegistrationRequestDto.getEmail())) {
            throw new RegistrationException("Email already exists");
        }

        User user = userMapper.toModel(userRegistrationRequestDto);
        user.setPassword(passwordEncoder.encode(userRegistrationRequestDto.getPassword()));

        Role userRole = roleRepository.findByName(Role.RoleName.USER)
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        user.setRoles(Set.of(userRole));
        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
