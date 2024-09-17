package com.riwi.complexus.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.domain.repositories.User_notificationsRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUser_notificationsService;

@Service
public class User_notificationsService implements IUser_notificationsService{
    
     @Autowired
    private User_notificationsRepo userNotificationsRepo;

    @Override
    public ResponseEntity<User_notificationsEntity> create(User_notificationsEntity userNotification) {
        User_notificationsEntity savedUserNotification = userNotificationsRepo.save(userNotification);
        return ResponseEntity.ok(savedUserNotification);
    }

    // @Override
    // public ResponseEntity<Optional<User_notificationsEntity>> findById(Long id) {
    //     Optional<User_notificationsEntity> userNotification = userNotificationsRepo.findById(id);
    //     return ResponseEntity.of(userNotification);
    // }

    @Override
    public ResponseEntity<List<User_notificationsEntity>> findAll() {
        List<User_notificationsEntity> userNotifications = userNotificationsRepo.findAll();
        return ResponseEntity.ok(userNotifications);
    }

    @Override
    public ResponseEntity<User_notificationsEntity> update(Long id, User_notificationsEntity userNotification) {
        if (userNotificationsRepo.existsById(id)) {
            userNotification.setId(id);
            User_notificationsEntity updatedUserNotification = userNotificationsRepo.save(userNotification);
            return ResponseEntity.ok(updatedUserNotification);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (userNotificationsRepo.existsById(id)) {
            userNotificationsRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Optional<User_notificationsEntity>> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
