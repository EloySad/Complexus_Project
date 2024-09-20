package com.riwi.complexus.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.complexus.domain.entities.NotificationsEntity;

@Repository
public interface NotificationsRepo extends JpaRepository<NotificationsEntity, Long>{
    
}
