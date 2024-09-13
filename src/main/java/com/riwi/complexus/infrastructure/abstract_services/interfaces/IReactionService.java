package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import java.util.List;

import com.riwi.complexus.domain.entities.ReactionEntity;

public interface IReactionService {
    ReactionEntity save(ReactionEntity reaction);
    ReactionEntity findById(Long id);
    List<ReactionEntity> findAll();
    void deleteById(Long id);
}
