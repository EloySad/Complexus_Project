package com.riwi.complexus.infrastructure.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.NotificationsEntity;
import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.NotificationsRepo;
import com.riwi.complexus.domain.repositories.interfaces.PostRepo;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.INotificationsService;
import com.riwi.complexus.utils.exceptions.ResourceNotFoundException;
import com.riwi.complexus.utils.exceptions.UnauthorizedException;


@Service
public class NotificationsService implements INotificationsService{
    
    @Autowired
    private NotificationsRepo notificationsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public ResponseEntity<NotificationsEntity> createPublicationWithNotification(Long adminId, Long postId, String message) {
        //Verifica que el usuario sea un administrador
        UserEntity admin = userRepo.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));

        if (!"admin".equals(admin.getRole().getName())) {
            throw new UnauthorizedException("User is not an admin");
        }
        // Verifica que el post exista
        PostEntity post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        // Crea la notificación para el post
        NotificationsEntity notification = NotificationsEntity.builder()
                .message(message)
                .createdAt(LocalDateTime.now())
                .post(post)
                  .build();
        // Guarda la notificación en la base de datos
        NotificationsEntity savedNotification = notificationsRepo.save(notification);
        // Envía la notificación a todos los usuarios
        List<UserEntity> users = userRepo.findAll();
        for (UserEntity user : users) {
            NotificationsEntity userNotification = NotificationsEntity.builder()
                    .message(message)
                    .createdAt(LocalDateTime.now())
                    .post(post)
                    .user(user)
                    .build();

            notificationsRepo.save(userNotification); // Guarda la notificación para cada usuario
        }

        return ResponseEntity.ok(savedNotification);// Retorna la notificación guardada
    }

    //Crea una nueva notificación.
    @Override
    public ResponseEntity<NotificationsEntity> create(NotificationsEntity notification) {
        NotificationsEntity savedNotification = notificationsRepo.save(notification);
        return ResponseEntity.ok(savedNotification);
    }

    // Busca una notificación por su ID.
    @Override
    public ResponseEntity<Optional<NotificationsEntity>> findById(Long id) {
        Optional<NotificationsEntity> notification = notificationsRepo.findById(id);
        return ResponseEntity.ok(notification);
    }

    //Recupera todas las notificaciones.
    @Override
    public ResponseEntity<List<NotificationsEntity>> findAll() {
        List<NotificationsEntity> notifications = notificationsRepo.findAll();
        return ResponseEntity.ok(notifications);
    }

    //Actualiza una notificación existente.
    @Override
    public ResponseEntity<NotificationsEntity> update(Long id, NotificationsEntity notification) {
        NotificationsEntity existingNotification = notificationsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));

         // Actualiza los campos de la notificación        
        existingNotification.setMessage(notification.getMessage());
        existingNotification.setCreatedAt(notification.getCreatedAt());
        existingNotification.setPost(notification.getPost());

         // Guarda la notificación actualizada
        NotificationsEntity updatedNotification = notificationsRepo.save(existingNotification);
        return ResponseEntity.ok(updatedNotification);
    }

    //Elimina una notificación por su ID.
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        NotificationsEntity notification = notificationsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));

        notificationsRepo.delete(notification);
        return ResponseEntity.noContent().build();// Retorna una respuesta sin contenido
    }
}
