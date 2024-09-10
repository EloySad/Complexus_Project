package com.riwi.complexus.api.controllers.generic;

public interface Create<EntityRequest ,Entity> {
    public Entity create(EntityRequest entity);
}
