package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.domain.entities.AdminEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface ISuperAdminService extends
        Create<AdminEntity>,
        Delete<Long>,
        Update<AdminEntity, Long>,
        ReadById<AdminEntity, Long>,
        ReadAll<AdminEntity> {
}
