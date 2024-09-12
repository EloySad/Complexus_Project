package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "SuperAdmin")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;
}
