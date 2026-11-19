package org.example.bookstorespringboot.security;

import lombok.RequiredArgsConstructor;
import org.example.bookstorespringboot.dto.UserLoginRequestDto;
import org.example.bookstorespringboot.dto.UserLoginResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserLoginResponseDto authenticate(UserLoginRequestDto request) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        String token = jwtUtil.getJwtToken(authenticate.getName());

        return new UserLoginResponseDto(token);
    }
}
