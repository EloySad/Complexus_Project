package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.api.dto.request.MediaRequest;
import com.riwi.complexus.api.dto.response.MediaResponse;
import com.riwi.complexus.domain.entities.MediaEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IMediaService extends
        CreateDTO<MediaEntity, MediaRequest>,
        Delete<Long>,
        ReadAll<MediaResponse>,
        ReadById<MediaResponse, Long>,
        Update<MediaRequest, Long> {
}
