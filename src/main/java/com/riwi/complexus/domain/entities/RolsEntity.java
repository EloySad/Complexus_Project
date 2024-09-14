package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "rol_entity")
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
}
