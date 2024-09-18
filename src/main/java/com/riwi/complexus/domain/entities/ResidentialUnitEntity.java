package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ResidentialUnit")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResidentialUnitEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unit")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "has_tower")
    private Boolean hasTower;

    // Relación muchos a uno con Admin
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    // Relación uno a muchos con User
    @OneToMany(mappedBy = "residentialUnit")
    private List<ResidentEntity> users;


}
