package com.riwi.complexus.infrastructure.services.interfaces;

import com.riwi.complexus.api.dto.request.AdminRequest;
import com.riwi.complexus.domain.entities.AdminEntity;
import com.riwi.complexus.infrastructure.services.CRUD.Create;

public interface IResidentialService extends
        Create<AdminRequest, AdminEntity>
        {
}
