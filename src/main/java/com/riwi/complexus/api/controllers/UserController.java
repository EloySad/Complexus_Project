package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.controllers.interfacesController.IUserController;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/readById/{id}")
    public UserEntity readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(UserEntity user) {
        return userService.create(user);
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    @GetMapping("/readAll")
    public List<UserEntity> readAll() {
        return userService.readAll();
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id,@RequestBody UserEntity user) {
        return userService.update(user, id);
    }
}
