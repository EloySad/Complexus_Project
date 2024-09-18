package com.riwi.complexus.infrastructure.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.NotificationsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.NotificationsRepo;
import com.riwi.complexus.domain.repositories.interfaces.UserRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.INotificationsService;


@Service
public class NotificationsService implements INotificationsService{
    
    @Autowired
    private NotificationsRepo notificationsRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<NotificationsEntity> createPublicationWithNotification(Long adminId, Long postId, String message) {
        Optional<UserEntity> optionalAdmin = userRepo.findById(adminId);
        if (!optionalAdmin.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserEntity admin = optionalAdmin.get();

        NotificationsEntity notification = NotificationsEntity.builder()
            .message(message)
            .createAt(LocalDateTime.now())
            .postId(postId)
            .admin(admin)
            .build();

        NotificationsEntity savedNotification = notificationsRepo.save(notification);

        List<UserEntity> users = userRepo.findAll();

        for (@SuppressWarnings("unused") UserEntity user : users) {
            NotificationsEntity userNotification = NotificationsEntity.builder()
                .message(message)
                .createAt(LocalDateTime.now())
                .postId(postId)
                .admin(admin)
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

    // @Override
    // public ResponseEntity<Optional<NotificationsEntity>> findById(Long id) {
    //     Optional<NotificationsEntity> notification = notificationsRepo.findById(id);
    //     return ResponseEntity.of(notification); 
    // }    


    @Override
    public ResponseEntity<List<NotificationsEntity>> findAll() {
        return ResponseEntity.ok(notificationsRepo.findAll());
    }

    @Override
    public ResponseEntity<NotificationsEntity> update(Long id, NotificationsEntity notification) {
        if (notificationsRepo.existsById(id)) {
            notification.setId(id);
            NotificationsEntity updatedNotification = notificationsRepo.save(notification);
            return ResponseEntity.ok(updatedNotification);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (notificationsRepo.existsById(id)) {
            notificationsRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Optional<NotificationsEntity>> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
   
}
