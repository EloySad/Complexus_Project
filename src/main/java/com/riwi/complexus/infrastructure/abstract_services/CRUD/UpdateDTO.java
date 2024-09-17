package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import com.riwi.complexus.domain.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UpdateDTO<Entity, ID, EntityRequest> {
    public ResponseEntity<Entity> update (ID id, EntityRequest entityRequest);
}
