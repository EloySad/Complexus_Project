package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;

import com.riwi.complexus.domain.entities.User_notificationsEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Archive;

public interface IUser_notificationsService extends Archive<Long>{
    User_notificationsEntity save(User_notificationsEntity userNotification);
    User_notificationsEntity findById(Long id);
    List<User_notificationsEntity> findAll();
    void deleteById(Long id);
}
