package com.riwi.complexus.domain.service;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;
import com.riwi.complexus.api.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    public AuthResponse register(UserRequest request, Long roleId);
    public List<UserResponse> getAllUsers();
}