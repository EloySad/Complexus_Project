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

import com.riwi.complexus.api.dto.response.NotificationsResponse;
import com.riwi.complexus.domain.entities.NotificationsEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.INotificationsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Notifications", description = "Notification Manager.")
public class NotificationsController {
    
    @Autowired
    private INotificationsService notificationsService;

    @PostMapping("/createPublicationWithNotification")
    @Operation(
            summary = "Create a publication with a notification.",
            description = "Create a notification of a post made by an Admin.")
            public ResponseEntity<NotificationsResponse> createPublicationWithNotification(
                @RequestParam Long adminId,
                @RequestParam Long postId,
                @RequestParam String message) {
            
            // Llamamos al servicio para crear la notificación
            ResponseEntity<NotificationsEntity> responseEntity = notificationsService.createPublicationWithNotification(adminId, postId, message);
            
            NotificationsEntity notification = responseEntity.getBody();            
            if (notification == null) {
                return ResponseEntity.notFound().build(); 
            }
            
            // Mapeamos la entidad al DTO de respuesta
            NotificationsResponse response = NotificationsResponse.builder()
                .message(notification.getMessage())
                .createdAt(notification.getCreatedAt())
                .postId(notification.getPost().getId())
                .userId(notification.getUser() != null ? notification.getUser().getId() : null) // Usando getUser()
                .build();
            
            return ResponseEntity.ok(response);
        }
    @PostMapping
    @Operation(
            summary = "Create a notification.",
            description = "Create a new notification in the system.")
    public ResponseEntity<NotificationsEntity> create(@RequestBody NotificationsEntity notification) {
        return notificationsService.create(notification);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a notification.",
            description = "Find the details of a specific notification using its ID.")
    public ResponseEntity<Optional<NotificationsEntity>> findById(@PathVariable Long id) {
        return notificationsService.findById(id); 
    }

    @GetMapping
    @Operation(
            summary = "Find all notifications.",
            description = "Find a list of all notifications in the system.")
    public ResponseEntity<List<NotificationsEntity>> findAll() {
        return notificationsService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a notification.",
            description = "Updates the details of an existing notification.")
    public ResponseEntity<NotificationsEntity> update(
            @PathVariable Long id,
            @RequestBody NotificationsEntity notification) {
        return notificationsService.update(id, notification);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a notification.",
            description = "Delete a system notification using its ID.")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return notificationsService.deleteById(id);
    }
}
