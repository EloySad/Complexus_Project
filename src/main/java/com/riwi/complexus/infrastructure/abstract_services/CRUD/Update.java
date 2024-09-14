package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import org.springframework.http.ResponseEntity;

public interface Update<Entity, ID> {
    public ResponseEntity<Entity> update (Entity entity, ID id);
}
