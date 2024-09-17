package com.riwi.complexus.infrastructure.abstract_services.CRUD;

public interface ReadById<T, ID>{
    public T readById(ID id);
}
