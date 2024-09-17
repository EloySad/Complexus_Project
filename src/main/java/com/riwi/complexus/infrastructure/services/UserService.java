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
        // Buscar el rol por su ID
        RolsEntity rol = rolService.readById(entity.getRoleId());

        if (rol == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Crear la entidad UserEntity y asignarle el rol encontrado
        UserEntity user = UserEntity.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .role(rol)  // Aquí se asigna la entidad RolsEntity completa
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
    public ResponseEntity<UserEntity> update(Long id, UserEntity userRequest) {
        UserEntity userExisting = userRepo.findById(id).orElse(null);

        if (userExisting == null) {
            return ResponseEntity.notFound().build();
        }
        RolsEntity rol = rolService.readById(userRequest.getId());

        if (rol == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body (null);
        }
        userExisting.setName(userRequest.getName());
        userExisting.setLastname(userRequest.getLastname());
        userExisting.setEmail(userRequest.getEmail());
        userExisting.setPassword(userRequest.getPassword());
        userExisting.setPhone(userRequest.getPhone());
        userExisting.setRole(rol);  // Asignar el rol

        UserEntity updatedUser = userRepo.save(userExisting);
        return ResponseEntity.ok(updatedUser);
    }
}
