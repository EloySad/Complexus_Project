package com.riwi.complexus.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.complexus.domain.entities.ReactionEntity;
import com.riwi.complexus.domain.repositories.interfaces.ReactionRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IReactionService;

@Service
public class ReactionService implements IReactionService{
    @Autowired
    private ReactionRepo reactionRepository;

    @Override
    public ReactionEntity save(ReactionEntity reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public ReactionEntity findById(Long id) {
        return reactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reaction not found"));
    }

    @Override
    public List<ReactionEntity> findAll() {
        return reactionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        reactionRepository.deleteById(id);
    }
}
