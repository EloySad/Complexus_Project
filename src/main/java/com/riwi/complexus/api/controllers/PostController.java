package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.PostRequest;
import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostRequest postRequest) {
        return postService.createDTO(postRequest);
    }

    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return new ResponseEntity<>(postService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.readById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long id, @RequestBody PostEntity post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
