package com.riwi.complexus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUser_notificationsService;

@RestController
@RequestMapping("/api/user-notifications")
public class User_notificationsController {
    
    @Autowired
    private IUser_notificationsService userNotificationsService;

    @PostMapping
    public ResponseEntity<User_notificationsEntity> createNotification(@RequestBody User_notificationsEntity userNotification) {
        User_notificationsEntity savedNotification = userNotificationsService.save(userNotification);
        return ResponseEntity.ok(savedNotification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_notificationsEntity> getNotificationById(@PathVariable Long id) {
        User_notificationsEntity userNotification = userNotificationsService.findById(id);
        if (userNotification != null) {
            return ResponseEntity.ok(userNotification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User_notificationsEntity>> getAllNotifications() {
        List<User_notificationsEntity> notifications = userNotificationsService.findAll();
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<String> archiveNotification(@PathVariable Long id) {
        String result = userNotificationsService.archive(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        userNotificationsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
