package com.riwi.complexus.infrastructure.abstract_services.interfaces;

import com.riwi.complexus.api.dto.request.PostRequest;
import com.riwi.complexus.domain.entities.PostEntity;
import com.riwi.complexus.infrastructure.abstract_services.CRUD.*;

public interface IPostService extends
        CreateDTO<PostEntity, PostRequest>,
        Delete<Long>,
        ReadAll<PostEntity>,
        ReadById<PostEntity, Long>,
        Update<PostEntity,Long> {

}
