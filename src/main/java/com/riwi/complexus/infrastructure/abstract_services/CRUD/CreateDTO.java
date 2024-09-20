package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import org.springframework.http.ResponseEntity;

public interface CreateDTO<Entity, EntityRequest> {
    public ResponseEntity<Entity> createDTO(EntityRequest entity);
}
