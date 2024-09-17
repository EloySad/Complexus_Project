package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import org.springframework.http.ResponseEntity;

public interface Update<Entity, ID> {
    public ResponseEntity<Entity> update (ID id, Entity entity);
}
