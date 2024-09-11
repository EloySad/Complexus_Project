package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tower")
    private Integer tower;

    @Column(name = "apto")
    private Integer apto;

    // Relación muchos a uno con ResidentialUnit
    @ManyToOne
    @JoinColumn(name = "residential_id")
    private ResidentialUnitEntity residentialUnit;

    // Relación uno a muchos con Notification
    @OneToMany(mappedBy = "user")
    private List<NotificationEntity> notifications;

    // Relación uno a muchos con Reaction
    @OneToMany(mappedBy = "user")
    private List<ReactionEntity> reactions;


}
