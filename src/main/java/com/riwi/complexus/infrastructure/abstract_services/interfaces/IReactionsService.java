package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.ReactionsEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Create;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Delete;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.ReadAll;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.ReadById;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Update;

public interface IReactionsService extends
    // Extiende la operación de creación de una nueva reacción (Create).
    Create<ReactionsEntity>,
    // Extiende la operación de eliminar una reacción por su ID (Delete).
    Delete<Long>,
    // Extiende la operación de leer todas las reacciones (ReadAll).
    ReadAll<ReactionsEntity>,
    // Extiende la operación de leer una reacción por su ID (ReadById).
    ReadById<ReactionsEntity, Long>,
    // Extiende la operación de actualizar una reacción por su ID (Update).
    Update<ReactionsEntity, Long> {
    
}
