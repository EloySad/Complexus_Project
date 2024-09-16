package com.riwi.complexus.infrastructure.services;


import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.domain.repositories.interfaces.PostRepo;

import com.riwi.complexus.infrastructure.abstract_services.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class PostService implements IPostService {

    @Autowired
    private PostRepo PostRepository;

    @Override
    public PostEntity save(PostEntity post){
        return PostRepository.save(post);
    }

    @Override
    public PostEntity findById(Long id) {
        return PostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<PostEntity> findAll() {
        return PostRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
    PostRepository.deleteById(id);
    }

}

