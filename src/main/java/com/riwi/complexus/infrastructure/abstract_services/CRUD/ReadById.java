package com.riwi.complexus.infrastructure.abstract_services.CRUD;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ReadById<Entity, ID>{
    public Entity readById(ID id);
}
