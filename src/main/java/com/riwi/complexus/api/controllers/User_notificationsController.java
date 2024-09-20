package com.riwi.complexus.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUser_notificationsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user_notifications")
public class User_notificationsController {
    
    @Autowired
    private IUser_notificationsService userNotificationsService;

    @PostMapping
    public ResponseEntity<User_notificationsEntity> create(@RequestBody User_notificationsEntity userNotification) {
        return userNotificationsService.create(userNotification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User_notificationsEntity>> findById(@PathVariable Long id) {
        return userNotificationsService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<User_notificationsEntity>> findAll() {
        return userNotificationsService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User_notificationsEntity> update(@PathVariable Long id,
        @RequestBody User_notificationsEntity userNotification) {
        return userNotificationsService.update(id, userNotification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return userNotificationsService.deleteById(id);
    }
}
