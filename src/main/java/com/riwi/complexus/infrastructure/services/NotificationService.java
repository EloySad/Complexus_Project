package com.riwi.complexus.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.NotificationEntity;
import com.riwi.complexus.domain.repositories.interfaces.NotificationRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.INotificationService;

@Service
public class NotificationService implements INotificationService{
    
    @Autowired
    private NotificationRepo notificationRepository;

    @Override
    public NotificationEntity save(NotificationEntity notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public NotificationEntity findById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    @Override
    public List<NotificationEntity> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public String archive(Long id) {
        NotificationEntity notification = findById(id);
        notification.setArchived(true);
        notificationRepository.save(notification);
        return "Notification archived successfully";
    }
}
