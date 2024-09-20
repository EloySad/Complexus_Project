package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.AuthRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;
import com.riwi.complexus.domain.ports.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
@Tag(name = "Authentication", description = "Manages authentication requests.")
public class AuthController {
    @Autowired
    private final IAuthService authService;

    @PostMapping("login")
    @Operation(
            summary = "Authenticate a user.",
            description = "Provides a user's data to generate a token that allows them to use private endpoints if their role allows it.")
    public ResponseEntity<AuthResponse> login(
            @Validated @RequestBody AuthRequest request) {
        return ResponseEntity.ok(this.authService.login(request));
    }
}