package com.riwi.complexus.infrastructure.services.CRUD;

public interface ReadById<Entity, ID> {
    public Entity readById( ID id);
}
