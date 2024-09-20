package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IUserService extends
        CreateDTO<UserEntity, UserRequest>,
        Delete<Long>,
        ReadAll<UserEntity>,
        ReadById<UserEntity, Long>,
        UpdateDTO<UserEntity, Long,UserRequest> {
}

