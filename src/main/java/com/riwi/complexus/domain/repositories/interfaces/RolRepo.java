package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.RolsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository <RolsEntity, Long> {
}
