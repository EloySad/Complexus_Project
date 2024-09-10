package com.riwi.complexus.domain.repositories;

import com.riwi.complexus.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
