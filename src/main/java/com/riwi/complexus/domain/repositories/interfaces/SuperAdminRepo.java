package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.SuperAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepo extends JpaRepository<SuperAdminEntity, Long> {
}
