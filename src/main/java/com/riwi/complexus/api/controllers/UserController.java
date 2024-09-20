package com.riwi.complexus.api.controllers;

import com.riwi.complexus.api.dto.request.UserRequest;
import com.riwi.complexus.api.dto.response.AuthResponse;
import com.riwi.complexus.api.dto.response.UserResponse;
import com.riwi.complexus.domain.entities.UserEntity;
import com.riwi.complexus.domain.ports.service.IUserService;
import com.riwi.complexus.infrastructure.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Manages user-related requests.")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IUserService userServices;

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("admin/register")
    @Operation(
            summary = "Create an admin.",
            description = "Provides the user data to create it and the token to validate the permissions.")
    public ResponseEntity<AuthResponse> registerAdmin(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userServices.register(request, 1L));
    }

    @PostMapping("/register")
    @Operation(
            summary = "Create a customer.",
            description = "Provides the user's data to create the client.")
    public ResponseEntity<AuthResponse> registerCustomer(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userServices.register(request, 2L));
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/readAllUsers")
    @Operation(
            summary = "List all users.",
            description = "Provide the token to validate the permissions and obtain the list of users.")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(this.userServices.getAllUsers());
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


    @GetMapping("/readById/{id}")
    public UserEntity readById(@PathVariable Long id) {
        return userService.readById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.update(id, userRequest);
    }
}
