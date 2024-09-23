package com.riwi.complexus.api.services;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;
import com.riwi.complexus.api.dto.response.UserResponse;
import com.riwi.complexus.api.mappers.UserMapper;
import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.exceptions.InvalidCredentialsException;
import com.riwi.complexus.domain.ports.service.IUserService;
import com.riwi.complexus.domain.repositories.interfaces.RolRepo;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.helpers.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private final UserRepo userRepository;

    @Autowired
    private final RolRepo rolRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtUtils jwtUtil;


    @Override
    public AuthResponse register(UserRequest request, Long roleId) {
        UserEntity userDB = userRepository.findByUsernameOrEmail(request.getName(),request.getEmail());
        RolsEntity role = rolRepo.findById(roleId).orElseThrow();
        if (userDB != null){
            throw new InvalidCredentialsException("Username register");
        }

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .username(request.getUsername())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(role)
                .build();

        user = this.userRepository.save(user);

        return AuthResponse.builder()
                .message(user.getRole() + " successfully authenticated")
                .token(this.jwtUtil.generateToken(user))
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return this.userRepository.findAll()
                .stream().map(user -> UserMapper.INSTANCE.userToUserResponse(user)).toList();
    }

}