package com.riwi.complexus.api.controllers;

import java.util.List;

import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.services.PostService;
import com.riwi.complexus.infrastructure.services.UserService;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/reactions")
@Tag(name = "Reactions", description = "Reaction Manager.")
public class ReactionsController {

    @Autowired
    private ReactionsService reactionsService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(
            summary = "Retrieves all reactions.",
            description = "Retrieves a list of all reactions in the system.")
    public List<ReactionsEntity> getAllReactions() {
        return reactionsService.readAll();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get a reaction.",
        description = "Retrieves the details of a specific reaction using its ID.")
    public ResponseEntity<ReactionsEntity> getReactionById(@PathVariable Long id) {
        ReactionsEntity reaction = reactionsService.readById(id);
        if (reaction == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reaction);
    }

    @PostMapping
    @Operation(
            summary = "Create a reaction.",
            description = "Create a new reaction to a post in the system.")
    public ResponseEntity<ReactionsEntity> createReaction(@RequestBody ReactionsRequest request) {
        PostEntity post = postService.readById(request.getPostId());
        UserEntity user = userService.readById(request.getUserId());

        if (post == null || user == null) {
            return ResponseEntity.badRequest().build();
        }

        ReactionsEntity reaction = ReactionsEntity.builder()
                .liked(request.getLiked())
                .createdAt(request.getCreatedAt())
                .post(post)
                .user(user)
                .build();

        return reactionsService.create(reaction);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Update a reaction.",
        description = "Updates the details of an existing reaction.")
    public ResponseEntity<ReactionsEntity> updateReaction(@PathVariable Long id, @RequestBody ReactionsRequest request) {
        PostEntity post = postService.readById(request.getPostId());
        UserEntity user = userService.readById(request.getUserId());

        if (post == null || user == null) {
            return ResponseEntity.badRequest().build();
        }

        ReactionsEntity reaction = ReactionsEntity.builder()
                .liked(request.getLiked())
                .createdAt(request.getCreatedAt())
                .post(post)
                .user(user)
                .build();

        return reactionsService.update(id, reaction);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete a reaction.",
        description = "Removes a reaction from the system using its ID.")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
