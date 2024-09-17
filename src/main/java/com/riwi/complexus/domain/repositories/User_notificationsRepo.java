package com.riwi.complexus.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.complexus.domain.entities.User_notificationsEntity;

@Repository
public interface User_notificationsRepo extends JpaRepository<User_notificationsEntity, Long>{
    
}
