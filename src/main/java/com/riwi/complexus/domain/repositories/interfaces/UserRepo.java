package com.riwi.complexus.domain.repositories.interfaces;

import com.riwi.complexus.domain.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsernameOrEmail(String name, String email);
}
