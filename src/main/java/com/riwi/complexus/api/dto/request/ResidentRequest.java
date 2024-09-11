package com.riwi.complexus.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ResidentRequest {
    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Lastname cannot be empty.")
    private String lastname;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @NotBlank(message = "Phone cannot be empty.")
    private String phone;

    @NotBlank(message = "Tower cannot be empty.")
    private Integer tower;

    @NotBlank(message = "Apto cannot be empty.")
    private Integer apto;
}
