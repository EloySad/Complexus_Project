package com.riwi.complexus.api.mappers;

import com.riwi.complexus.api.dto.response.UserResponse;
import com.riwi.complexus.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserResponse userToUserResponse(UserEntity user);
}