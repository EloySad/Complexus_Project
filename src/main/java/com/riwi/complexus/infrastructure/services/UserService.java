package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RolService rolService;

    @Override
    public ResponseEntity<UserEntity> createDTO(UserRequest entity) {
        RolsEntity rol = rolService.readById(entity.getRoleId());
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        UserEntity user = UserEntity.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .role(rol)
                .build();

        UserEntity savedUser = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<UserEntity> readAll() {
        return userRepo.findAll();
    }

    @Override
    public UserEntity readById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<UserEntity> update(Long id, UserRequest userRequest) {
        RolsEntity rol = rolService.readById(userRequest.getRoleId());
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        UserEntity userExisting = userRepo.findById(id).orElse(null);

        if (userExisting == null) {
            return ResponseEntity.notFound().build();
        }

        userExisting.setName(userRequest.getName());
        userExisting.setLastname(userRequest.getLastname());
        userExisting.setEmail(userRequest.getEmail());
        userExisting.setPassword(userRequest.getPassword());
        userExisting.setPhone(userRequest.getPhone());
        userExisting.setRole(rol);

        UserEntity updatedUser = userRepo.save(userExisting);
        return ResponseEntity.ok(updatedUser);
    }
}
