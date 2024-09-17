package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> create(@RequestBody UserRequest userRequest) {
        return userService.createDTO(userRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/readAll")
    public List<UserEntity> readAll() {
        return userService.readAll();
    }

    @GetMapping("/readById/{id}")
    public UserEntity readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.update(id, userEntity);
    }
}
