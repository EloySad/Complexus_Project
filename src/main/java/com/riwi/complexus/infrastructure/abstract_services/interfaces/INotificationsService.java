package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.riwi.complexus.domain.entities.NotificationsEntity;

public interface INotificationsService {
    //Crea una nueva notificación.
    ResponseEntity<NotificationsEntity> create(NotificationsEntity notification);
    //Busca una notificación por su ID.
    ResponseEntity<Optional<NotificationsEntity>> findById(Long id);
    //Recupera todas las notificaciones.
    ResponseEntity<List<NotificationsEntity>> findAll();
    //Actualiza una notificación existente.
    ResponseEntity<NotificationsEntity> update(Long id, NotificationsEntity notification);
    //Elimina una notificación por su ID.
    ResponseEntity<Void> deleteById(Long id);
    // Crea una publicación con una notificación asociada, normalmente realizada por un administrador.
    ResponseEntity<NotificationsEntity> createPublicationWithNotification(Long adminId, Long postId, String message);
}
