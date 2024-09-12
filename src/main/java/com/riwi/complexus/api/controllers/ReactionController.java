package com.riwi.complexus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.complexus.domain.entities.ReactionEntity;
import com.riwi.complexus.infrastructure.services.ReactionService;

@RestController
@RequestMapping("/ap/reactions")
public class ReactionController {
    
    @Autowired
    private ReactionService reactionService;

    @PostMapping
    public ResponseEntity<ReactionEntity> createReaction(@RequestBody ReactionEntity reaction) {
        ReactionEntity savedReaction = reactionService.save(reaction);
        return ResponseEntity.ok(savedReaction);
    }

    @GetMapping
    public ResponseEntity<List<ReactionEntity>> getAllReactions() {
        List<ReactionEntity> reactions = reactionService.findAll();
        return ResponseEntity.ok(reactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReactionEntity> getReactionById(@PathVariable Long id) {
        ReactionEntity reaction = reactionService.findById(id);
        return ResponseEntity.ok(reaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
