package com.riwi.complexus.api.controllers.generic;

import org.springframework.http.ResponseEntity;

public interface Update<ID, Entity> {
    public ResponseEntity<Entity> update (ID id, Entity entity);
}
