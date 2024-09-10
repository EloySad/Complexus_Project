package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ResidentialUnit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResidentialUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean hasTower;

}
