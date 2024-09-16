package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Archive;

import java.util.List;

public interface IMediaService extends Archive<Long> {
    MediaEntity save(MediaEntity media);
    MediaEntity findById(Long id);
    List<MediaEntity> findAll();
    void deleteById(Long id);
}
