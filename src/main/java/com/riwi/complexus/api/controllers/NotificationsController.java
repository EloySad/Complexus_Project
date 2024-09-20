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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.complexus.domain.entities.NotificationsEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.INotificationsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {
    
    @Autowired
    private INotificationsService notificationsService;

    @PostMapping("/createPublicationWithNotification")
    public ResponseEntity<NotificationsEntity> createPublicationWithNotification(
            @RequestParam Long adminId,
            @RequestParam Long postId,
            @RequestParam String message) {
        return notificationsService.createPublicationWithNotification(adminId, postId, message);
    }

    @PostMapping
    public ResponseEntity<NotificationsEntity> create(@RequestBody NotificationsEntity notification) {
        return notificationsService.create(notification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NotificationsEntity>> findById(@PathVariable Long id) {
        return notificationsService.findById(id); 
    }

    @GetMapping
    public ResponseEntity<List<NotificationsEntity>> findAll() {
        return notificationsService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationsEntity> update(
            @PathVariable Long id,
            @RequestBody NotificationsEntity notification) {
        return notificationsService.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return notificationsService.deleteById(id);
    }
}
