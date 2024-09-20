package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.api.dto.request.ResidentialUnitRequest;
import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IResidentialUnitService extends
        CreateDTO<ResidentialUnitEntity, ResidentialUnitRequest>,
        Delete<Long>,
        ReadAll<ResidentialUnitEntity>,
        ReadById<ResidentialUnitEntity, Long>,
        UpdateDTO<ResidentialUnitEntity, Long,ResidentialUnitRequest> {
}
