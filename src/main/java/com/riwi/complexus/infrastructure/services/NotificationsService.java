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
        UserEntity admin = userRepo.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));

        if (!"admin".equals(admin.getRole().getName())) {
            throw new UnauthorizedException("User is not an admin");
        }

        PostEntity post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        NotificationsEntity notification = NotificationsEntity.builder()
                .message(message)
                .createdAt(LocalDateTime.now())
                .post(post)
                  .build();

        NotificationsEntity savedNotification = notificationsRepo.save(notification);

        List<UserEntity> users = userRepo.findAll();
        for (UserEntity user : users) {
            NotificationsEntity userNotification = NotificationsEntity.builder()
                    .message(message)
                    .createdAt(LocalDateTime.now())
                    .post(post)
                    .user(user)
                    .build();

            notificationsRepo.save(userNotification);
        }

        return ResponseEntity.ok(savedNotification);
    }


    @Override
    public ResponseEntity<NotificationsEntity> create(NotificationsEntity notification) {
        NotificationsEntity savedNotification = notificationsRepo.save(notification);
        return ResponseEntity.ok(savedNotification);
    }

    @Override
    public ResponseEntity<Optional<NotificationsEntity>> findById(Long id) {
        Optional<NotificationsEntity> notification = notificationsRepo.findById(id);
        return ResponseEntity.ok(notification);
    }

    @Override
    public ResponseEntity<List<NotificationsEntity>> findAll() {
        List<NotificationsEntity> notifications = notificationsRepo.findAll();
        return ResponseEntity.ok(notifications);
    }

    @Override
    public ResponseEntity<NotificationsEntity> update(Long id, NotificationsEntity notification) {
        NotificationsEntity existingNotification = notificationsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));

        existingNotification.setMessage(notification.getMessage());
        existingNotification.setCreatedAt(notification.getCreatedAt());
        existingNotification.setPost(notification.getPost());


        NotificationsEntity updatedNotification = notificationsRepo.save(existingNotification);
        return ResponseEntity.ok(updatedNotification);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        NotificationsEntity notification = notificationsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));

        notificationsRepo.delete(notification);
        return ResponseEntity.noContent().build();
    }
}
