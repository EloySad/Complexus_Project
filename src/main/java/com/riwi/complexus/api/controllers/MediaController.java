package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.MediaRequest;
import com.riwi.complexus.api.dto.response.MediaResponse;
import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final IMediaService mediaService;

    @Autowired
    public MediaController(IMediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public ResponseEntity<MediaResponse> createMedia(@RequestBody MediaRequest mediaRequest) {
        MediaEntity createdMedia = mediaService.createDTO(mediaRequest);
        MediaResponse response = mediaService.readById(createdMedia.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaResponse> getMediaById(@PathVariable Long id) {
        MediaResponse response = mediaService.readById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MediaResponse>> getAllMedia() {
        List<MediaResponse> responseList = mediaService.readAll();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaResponse> updateMedia(@PathVariable Long id, @RequestBody MediaRequest mediaRequest) {
        MediaEntity media = new MediaEntity();
        media.setId(id);
        media.setUrl(mediaRequest.getUrl());
        MediaResponse response = mediaService.update(id, media);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
