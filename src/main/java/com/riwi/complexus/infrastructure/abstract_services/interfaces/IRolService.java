package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.RolsEntity;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IRolService extends
        Create<RolsEntity>,
        Delete<Long>,
        ReadAll<RolsEntity>,
        ReadById<RolsEntity, Long>,
        Update<RolsEntity, Long> {
}
