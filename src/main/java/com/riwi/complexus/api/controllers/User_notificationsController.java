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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user_notifications")
@Tag(name = "User_notifications", description = "User_notification Manager.")
public class User_notificationsController {
    
    @Autowired
    private IUser_notificationsService userNotificationsService;

    @PostMapping
    @Operation(
            summary = "Create a notification for user.",
            description = "Create a new notification for a user in the system.")
    public ResponseEntity<User_notificationsEntity> create(@RequestBody User_notificationsEntity userNotification) {
        return userNotificationsService.create(userNotification);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a notification for user.",
            description = "Retrieves the details of a specific notification using its ID.")
    public ResponseEntity<Optional<User_notificationsEntity>> findById(@PathVariable Long id) {
        return userNotificationsService.findById(id);
    }

    @GetMapping
    @Operation(
            summary = "Find all notification for user.",
            description = "Retrieves a list of all notifications from a specific user.")
    public ResponseEntity<List<User_notificationsEntity>> findAll() {
        return userNotificationsService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update notifications for user.",
            description = "Updates the status of an existing notification (for example, mark as viewed).")
    public ResponseEntity<User_notificationsEntity> update(@PathVariable Long id,
        @RequestBody User_notificationsEntity userNotification) {
        return userNotificationsService.update(id, userNotification);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a notification for user.",
            description = "Delete a system notification using its ID.")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return userNotificationsService.deleteById(id);
    }
}
