package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.MediaRequest;
import com.riwi.complexus.api.dto.response.MediaResponse;
import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.infrastructure.abstract_services.interfaces.IMediaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@Tag(name = "Media", description = "Multimedia resources.")
public class MediaController {

    private final IMediaService mediaService;

    public MediaController(IMediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("create")
    @Operation(
            summary = "Create a media.",
            description = "Create a new image entry in the system.")
    public ResponseEntity<MediaResponse> createMedia(@RequestBody MediaRequest mediaRequest) {
        MediaEntity createdMedia = mediaService.createDTO(mediaRequest);
        MediaResponse response = mediaService.readById(createdMedia.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getById/{id}")
    @Operation(
            summary = "Get a media.",
            description = "Retrieves the details of a specific image using its ID.")
    public ResponseEntity<MediaResponse> getMediaById(@PathVariable Long id) {
        MediaResponse response = mediaService.readById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("readAll")
    @Operation(
            summary = "Get all media.",
            description = "Retrieves a list of all images on the system.")
    public ResponseEntity<List<MediaResponse>> getAllMedia() {
        List<MediaResponse> responseList = mediaService.readAll();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Operation(
            summary = "Update a media.",
            description = "Updates the details of an existing image.")
    public ResponseEntity<MediaResponse> updateMedia(@PathVariable Long id, @RequestBody MediaRequest mediaRequest) {
        MediaEntity media = new MediaEntity();
        media.setId(id);
        media.setUrl(mediaRequest.getUrl());
        MediaResponse response = mediaService.update(id, media);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delet/{id}")
    @Operation(
            summary = "Delete a media.",
            description = "Removes an image from the system using its ID.")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
