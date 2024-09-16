package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "residents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String tower;

    @Column(nullable = false, length = 100)
    private String residentialNumber;

    @Column
    private Boolean allowedNotification ;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "residential_unit_id")
    private ResidentialUnitEntity residentialUnitId;
}
