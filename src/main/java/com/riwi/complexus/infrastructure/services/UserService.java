package com.riwi.complexus.infrastructure.services;

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
        UserEntity user = UserEntity.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .role(entity.getRole())
                .build();

        UserEntity saveUser = userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(saveUser);
    }

    @Override
    public ResponseEntity<UserEntity> update(Long id, UserEntity userEntity) {
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