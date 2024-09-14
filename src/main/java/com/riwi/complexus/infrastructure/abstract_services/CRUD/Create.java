package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import org.springframework.http.ResponseEntity;

public interface Create <Entity> {
    public ResponseEntity<Entity> create(Entity entity);
}
