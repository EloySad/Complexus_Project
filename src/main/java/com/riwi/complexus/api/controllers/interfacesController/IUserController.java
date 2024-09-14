package com.riwi.complexus.api.controllers.interfacesController;

import com.riwi.complexus.api.controllers.generic.ReadById;
import com.riwi.complexus.api.controllers.generic.Update;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Create;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.Delete;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.ReadAll;

public interface IUserController extends
        Create<UserEntity>,
        Delete<Long>,
        ReadAll<UserEntity>,
        ReadById<UserEntity, Long>,
        Update<UserEntity, Long> {
}
