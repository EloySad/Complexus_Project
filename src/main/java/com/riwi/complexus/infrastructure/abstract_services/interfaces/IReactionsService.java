package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.ReactionsEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Create;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Delete;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.ReadAll;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.ReadById;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Update;

public interface IReactionsService extends
    Create<ReactionsEntity>,
    Delete<Long>,
    ReadAll<ReactionsEntity>,
    ReadById<ReactionsEntity, Long>,
    Update<ReactionsEntity, Long> {
    
}
