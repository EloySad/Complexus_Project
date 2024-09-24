package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.PostRequest;
import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IPostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post", description = "Publication Manager.")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("create")
    @Operation(
            summary = "Create a post.",
            description = "Create a new post in the system.")
    public ResponseEntity<PostEntity> createPost(@RequestBody PostRequest postRequest) {
        return postService.createDTO(postRequest);
    }

    @GetMapping("readAll")
    @Operation(
            summary = "Retrieves all notifications.",
            description = "Retrieves a list of all posts in the system.")
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return new ResponseEntity<>(postService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/readById/{id}")
    @Operation(
            summary = "Retrieves a notification.",
            description = "Retrieves the details of a specific post using its ID.")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.readById(id));
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update a notification.",
            description = "Updates the details of an existing post.")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long id, @RequestBody PostEntity post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete a notification.",
            description = "Delete a post from the system using its ID.")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
