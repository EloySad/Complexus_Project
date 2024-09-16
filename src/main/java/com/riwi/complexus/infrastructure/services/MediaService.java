package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.MediaRequest;
import com.riwi.complexus.api.dto.response.MediaResponse;
import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.domain.repositories.interfaces.MediaRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MediaService implements IMediaService {
    @Autowired
    private MediaRepo mediaRepository;

    @Override
    public MediaEntity save(MediaEntity media) {
        return mediaRepository.save(media);
    }

    public MediaResponse save(MediaRequest request) {
        MediaEntity media = new MediaEntity();
        media.setUrl(request.getUrl());

        MediaEntity savedMedia = save(media);

        return mapToDto(savedMedia);
    }

    @Override
    public MediaEntity findById(Long id) {
        return mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found"));
    }

    @Override
    public List<MediaEntity> findAll() {
        return mediaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        mediaRepository.deleteById(id);
    }

    private MediaResponse mapToDto(MediaEntity media) {
        return MediaResponse.builder()
                .id(media.getId())
                .url(media.getUrl())
                .build();
    }


    @Override
    public String archive(Long aLong) {
        return "";
    }
}

