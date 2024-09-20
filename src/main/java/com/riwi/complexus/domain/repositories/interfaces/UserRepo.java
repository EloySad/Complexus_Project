package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByNameOrEmail(String name, String email);
}
