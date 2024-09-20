package com.riwi.complexus.domain.ports.service;

import com.riwi.complexus.api.dto.request.AuthRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;

public interface IAuthService {
    public AuthResponse login(AuthRequest request);
}
