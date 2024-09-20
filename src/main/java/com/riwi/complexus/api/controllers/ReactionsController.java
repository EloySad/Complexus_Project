package com.riwi.complexus.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.complexus.api.dto.request.ReactionsRequest;
import com.riwi.complexus.domain.entities.ReactionsEntity;
import com.riwi.complexus.infrastructure.services.ReactionsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/reactions")
public class ReactionsController {
    
    @Autowired
    private ReactionsService reactionsService;

    @GetMapping
    public List<ReactionsEntity> getAllReactions() {
        return reactionsService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReactionsEntity> getReactionById(@PathVariable Long id) {
        ReactionsEntity reaction = reactionsService.readById(id);
        return ResponseEntity.ok(reaction);
    }

    @PostMapping
    public ResponseEntity<ReactionsEntity> createReaction(@RequestBody ReactionsRequest request) {
        ReactionsEntity reaction = ReactionsEntity.builder()
                .liked(request.getLiked())
                .createdAt(request.getCreatedAt()) 
                .build();
        return reactionsService.create(reaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReactionsEntity> updateReaction(@PathVariable Long id, @RequestBody ReactionsRequest request) {
        ReactionsEntity reaction = ReactionsEntity.builder()
                .liked(request.getLiked())
                .createdAt(request.getCreatedAt()) 
                .build();
        return reactionsService.update(id, reaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
