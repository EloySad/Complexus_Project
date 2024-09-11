package com.riwi.complexus.domain.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.complexus.domain.entities.NotificationEntity;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationEntity, Long>{
}
