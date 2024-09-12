package com.riwi.complexus.domain.entities;

import com.riwi.complexus.utils.enums.RolsAdmin;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Admins")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private RolsAdmin role;

    // Relación uno a muchos con Advice
    @OneToMany(mappedBy = "admin")
    private List<AdviceEntity> advices;

    // Relación uno a muchos con Notification
    @OneToMany(mappedBy = "admin")
    private List<NotificationEntity> notifications;

    // Relación uno a muchos con Reaction
    @OneToMany(mappedBy = "admin")
    private List<ReactionEntity> reactions;

    // Relación uno a muchos con ResidentialUnit
    @OneToMany(mappedBy = "admin")
    private List<ResidentialUnitEntity> residentialUnits;



}
