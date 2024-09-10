package com.riwi.complexus.infrastructure.services.CRUD;

public interface Create<EntityRequest ,Entity> {
    public Entity create(EntityRequest entity);
}
