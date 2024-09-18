package com.riwi.complexus.infrastructure.services;

import com.riwi.complexus.api.dto.request.MediaRequest;
import com.riwi.complexus.api.dto.response.MediaResponse;
import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.domain.repositories.interfaces.MediaRepo;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaService implements IMediaService {

    @Autowired
    private MediaRepo mediaRepository;

    @Override
    public MediaEntity createDTO(MediaRequest request) {
        MediaEntity media = new MediaEntity();
        media.setUrl(request.getUrl());
        return mediaRepository.save(media);
    }

    @Override
    public void delete(Long id) {
        mediaRepository.deleteById(id);
    }

    @Override
    public List<MediaResponse> readAll() {
        List<MediaEntity> mediaEntities = mediaRepository.findAll();
        return mediaEntities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MediaResponse readById(Long id) {
        MediaEntity media = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found"));
        return mapToDto(media);
    }

    @Override
    public MediaResponse update(Long id, MediaEntity media) {
        MediaEntity existingMedia = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found"));
        existingMedia.setUrl(media.getUrl());
        MediaEntity updatedMedia = mediaRepository.save(existingMedia);
        return mapToDto(updatedMedia);
    }

    private MediaResponse mapToDto(MediaEntity media) {
        return MediaResponse.builder()
                .id(media.getId())
                .url(media.getUrl())
                .build();
    }


    @Override
    public ResponseEntity<MediaRequest> update(Long aLong, MediaRequest mediaRequest) {
        return null;
    }
}
