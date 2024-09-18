package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IUserService extends
        Create<UserEntity>,
        Delete<Long>,
        ReadAll<UserEntity>,
        ReadById<UserEntity, Long>,
        Update<UserEntity, Long> {
}
