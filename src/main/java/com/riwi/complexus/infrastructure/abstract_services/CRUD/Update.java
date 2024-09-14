package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import com.riwi.complexus.domain.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface Update<Entity, ID> {
    public ResponseEntity<UserEntity> update (ID id, Entity entity);
}
