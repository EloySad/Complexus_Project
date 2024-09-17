package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.RolRepo;
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
    RolRepo rolRepo;

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
        return userRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @Override
    public ResponseEntity<UserEntity> create(UserEntity entity) {
entity.
        RolsEntity role = rolRepo.findById(entity.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UserEntity user = UserEntity.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .role(role)
                .build();

        UserEntity saveUser = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(saveUser);
    }

    @Override
    public ResponseEntity<UserEntity> update(Long id, UserEntity userEntity) {

        RolsEntity role = rolRepo.findById(userEntity.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UserEntity userExisting = userRepo.findById(id).orElse(null);
        if(userExisting != null){
            userExisting.setName(userEntity.getName());
            userExisting.setLastname(userEntity.getLastname());
            userExisting.setEmail(userEntity.getEmail());
            userExisting.setPassword(userEntity.getPassword());
            userExisting.setPhone(userEntity.getPhone());
            userExisting.setRole(userEntity.getRole());

            UserEntity saveUser = userRepo.save(userExisting);
            return ResponseEntity.ok(saveUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
