package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;

import com.riwi.complexus.domain.entities.NotificationEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Archive;

public interface INotificationService extends Archive<Long>{
    NotificationEntity save(NotificationEntity notification);
    NotificationEntity findById(Long id);
    List<NotificationEntity> findAll();
    void deleteById(Long id);
}
