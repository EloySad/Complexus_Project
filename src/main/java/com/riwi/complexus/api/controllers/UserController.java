package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.controllers.interfacesController.IUserController;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @Override
    public UserEntity readById(Long aLong) {
        return null;
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return null;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<UserEntity> create(UserEntity user) {
        return userService.create(user);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<UserEntity> readAll() {
        return List.of();
    }

}
