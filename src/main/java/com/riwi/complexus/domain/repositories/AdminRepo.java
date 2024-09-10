package com.riwi.complexus.domain.repositories;

import com.riwi.complexus.domain.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {
}
