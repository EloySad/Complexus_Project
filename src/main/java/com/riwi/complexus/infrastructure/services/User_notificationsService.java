package com.riwi.complexus.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.domain.repositories.User_notificationsRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUser_notificationsService;

@Service
public class User_notificationsService implements IUser_notificationsService{
    
    private final User_notificationsRepo userNotificationsRepo;

    
    public User_notificationsService(User_notificationsRepo userNotificationsRepo) {
        this.userNotificationsRepo = userNotificationsRepo;
    }

    @Override
    public ResponseEntity<User_notificationsEntity> create(User_notificationsEntity userNotification) {
        User_notificationsEntity savedUserNotification = userNotificationsRepo.save(userNotification);
        return ResponseEntity.ok(savedUserNotification);
    }
    
    @Override
    public ResponseEntity<Optional<User_notificationsEntity>> findById(Long id) {
        Optional<User_notificationsEntity> notification = userNotificationsRepo.findById(id);
        return ResponseEntity.ok(notification);
    }

    @Override
    public ResponseEntity<List<User_notificationsEntity>> findAll() {
        List<User_notificationsEntity> userNotifications = userNotificationsRepo.findAll();
        return ResponseEntity.ok(userNotifications);
    }

    @Override
    public ResponseEntity<User_notificationsEntity> update(Long id, User_notificationsEntity userNotification) {
        if (!userNotificationsRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userNotification.setId(id);
        User_notificationsEntity updatedUserNotification = userNotificationsRepo.save(userNotification);
        return ResponseEntity.ok(updatedUserNotification);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (!userNotificationsRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userNotificationsRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
