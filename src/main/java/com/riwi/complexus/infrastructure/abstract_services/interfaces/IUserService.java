package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IUserService extends
        Delete<Long> ,
        Update<UserEntity,Long>,
        ReadById<UserEntity,Long>,
        ReadAll<UserEntity>,
        Create<UserEntity> {
}
