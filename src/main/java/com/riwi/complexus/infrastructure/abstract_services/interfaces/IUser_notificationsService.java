package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.riwi.complexus.domain.entities.User_notificationsEntity;

public interface IUser_notificationsService {

    ResponseEntity<User_notificationsEntity> create(User_notificationsEntity userNotification);
    
    ResponseEntity<Optional<User_notificationsEntity>> findById(Long id); // Usa Optional si es necesario
    
    ResponseEntity<List<User_notificationsEntity>> findAll();
    
    ResponseEntity<User_notificationsEntity> update(Long id, User_notificationsEntity userNotification);
    
    ResponseEntity<Void> deleteById(Long id);
}
