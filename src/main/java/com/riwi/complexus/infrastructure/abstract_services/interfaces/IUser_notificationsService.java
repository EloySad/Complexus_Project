package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.riwi.complexus.domain.entities.User_notificationsEntity;

public interface IUser_notificationsService {
    //Crea una nueva notificación de usuario.
    ResponseEntity<User_notificationsEntity> create(User_notificationsEntity userNotification);
    //Busca una notificación de usuario por su ID.
    ResponseEntity<Optional<User_notificationsEntity>> findById(Long id); // Usa Optional si es necesario
    //Recupera todas las notificaciones de usuario.
    ResponseEntity<List<User_notificationsEntity>> findAll();
    //Actualiza una notificación de usuario existente.
    ResponseEntity<User_notificationsEntity> update(Long id, User_notificationsEntity userNotification);
    //Elimina una notificación de usuario por su ID.
    ResponseEntity<Void> deleteById(Long id);
}
