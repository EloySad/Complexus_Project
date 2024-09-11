package com.riwi.complexus.infrastructure.abstract_services.CRUD;

public interface ReadById<Entity, ID> {
    public Entity readById( ID id);
}
