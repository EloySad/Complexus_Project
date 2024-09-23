package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.PostRequest;
import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.repositories.interfaces.PostRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<PostEntity> createDTO(PostRequest postRequest) {
        UserEntity user = userService.readById(postRequest.getUserId());

        PostEntity postEntity = PostEntity.builder()
                .title(postRequest.getTitle())
                .user(user)
                .description(postRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .pinned(postRequest.isPinned())
                .build();

        PostEntity savedPost = postRepo.save(postEntity);
        return ResponseEntity.ok(savedPost);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<PostEntity> readAll() {
        return postRepo.findAll();
    }

    @Override
    public PostEntity readById(Long id) {
        return postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public ResponseEntity<PostEntity> update(Long id, PostEntity post) {
        PostEntity existingPost = postRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        existingPost.setTitle(post.getTitle());
        existingPost.setDescription(post.getDescription());
        existingPost.setPinned(post.isPinned());

        PostEntity updatedPost = postRepo.save(existingPost);
        return ResponseEntity.ok(updatedPost);
    }
}
