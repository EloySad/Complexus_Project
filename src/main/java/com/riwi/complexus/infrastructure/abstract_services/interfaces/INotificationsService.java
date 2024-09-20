package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.riwi.complexus.domain.entities.NotificationsEntity;

public interface INotificationsService {
    ResponseEntity<NotificationsEntity> create(NotificationsEntity notification);
    ResponseEntity<Optional<NotificationsEntity>> findById(Long id);
    ResponseEntity<List<NotificationsEntity>> findAll();
    ResponseEntity<NotificationsEntity> update(Long id, NotificationsEntity notification);
    ResponseEntity<Void> deleteById(Long id);
    ResponseEntity<NotificationsEntity> createPublicationWithNotification(Long adminId, Long postId, String message);
}
