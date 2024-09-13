package com.riwi.complexus.domain.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.complexus.domain.entities.ReactionEntity;

public interface ReactionRepo extends JpaRepository<ReactionEntity, Long>{
    
}
