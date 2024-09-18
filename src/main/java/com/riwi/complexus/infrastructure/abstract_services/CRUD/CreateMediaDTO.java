package com.riwi.complexus.infrastructure.abstract_services.CRUD;

public interface CreateMediaDTO <Entity, Request> {
    Entity createDTO(Request request);
}
