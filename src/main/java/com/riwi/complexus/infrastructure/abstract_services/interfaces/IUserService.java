package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;
import org.springframework.http.ResponseEntity;

public interface IUserService extends

        Delete<Long>,
        ReadById<UserEntity, Long>,
        UpdateDTO<UserEntity, Long,UserRequest> {
}
