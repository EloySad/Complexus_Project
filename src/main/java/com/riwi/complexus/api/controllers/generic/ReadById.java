package com.riwi.complexus.api.controllers.generic;

public interface ReadById<Entity, ID> {
    public Entity readById( ID id);
}
