package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import org.springframework.http.ResponseEntity;

public interface Create <EntityDto> {
    public ResponseEntity<EntityDto> create(EntityDto entityDto);
}
