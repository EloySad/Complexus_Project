package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.ResidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<ResidentEntity, Integer> {
}
