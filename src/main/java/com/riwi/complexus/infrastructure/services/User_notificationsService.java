package com.riwi.complexus.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.domain.repositories.User_notificationsRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IUser_notificationsService;

@Service
public class User_notificationsService implements IUser_notificationsService{

    @Autowired
    private User_notificationsRepo userNotificationsRepository;

    @Override
    public User_notificationsEntity save(User_notificationsEntity userNotification) {
        return userNotificationsRepository.save(userNotification);
    }

    @Override
    public User_notificationsEntity findById(Long id) {
        Optional<User_notificationsEntity> result = userNotificationsRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<User_notificationsEntity> findAll() {
        return userNotificationsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userNotificationsRepository.deleteById(id);
    }

    @Override
    public String archive(Long id) {
        Optional<User_notificationsEntity> result = userNotificationsRepository.findById(id);
        if (result.isPresent()) {
            User_notificationsEntity userNotification = result.get();
            // Marcar la notificación como archivada
            userNotification.setArchived(true); // Establece el campo 'archived' en true
            userNotificationsRepository.save(userNotification); // Guarda los cambios en la base de datos
            return "Notificación archivada con éxito";
        } else {
            return "Notificación no encontrada con ID: " + id;
        }

    }
}

