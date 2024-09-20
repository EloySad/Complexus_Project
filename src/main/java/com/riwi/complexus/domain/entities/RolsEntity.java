package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users;
}
