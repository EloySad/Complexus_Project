package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Archive;

import java.util.List;

public interface IPostService extends Archive<Long> {
    PostEntity save(PostEntity post);
    PostEntity findById(Long id);
    List<PostEntity> findAll();
    void  deleteById(Long id);
}
