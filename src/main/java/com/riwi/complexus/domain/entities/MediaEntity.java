package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity(name = "Media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "media_1", length = 300)
    private String media1;

    @Column(name = "media_2", length = 300)
    private String media2;

    @Column(name = "media_3", length = 300)
    private String media3;

    @Column(name = "media_4", length = 300)
    private String media4;

    @Column(name = "media_5", length = 300)
    private String media5;

    @ManyToOne
    @JoinColumn(name = "advice_id", nullable = false)
    private AdviceEntity advice;
}
