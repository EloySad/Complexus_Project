package com.riwi.complexus.infrastructure.abstract_services.CRUD;

public interface Create<EntityRequest ,Entity> {
    public Entity create(EntityRequest entity);
}
