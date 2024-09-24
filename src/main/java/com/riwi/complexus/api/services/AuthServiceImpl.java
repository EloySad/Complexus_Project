package com.riwi.complexus.api.services;

import com.riwi.complexus.api.dto.request.AuthRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.exceptions.InvalidCredentialsException;
import com.riwi.complexus.domain.ports.service.IAuthService;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.helpers.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private final JwtUtils jwtUtil;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @Override
    public AuthResponse login(AuthRequest request) {

        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(request.getIdentifier());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }

        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getIdentifier(), request.getPassword()));

        return AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .message(user.getRole() + " successfully authenticated")
                .token(this.jwtUtil.generateToken(user))
                .build();
    }

}
