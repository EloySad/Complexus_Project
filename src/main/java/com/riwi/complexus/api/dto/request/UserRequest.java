package com.riwi.complexus.api.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 200)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 40)
    private String phone;
}

