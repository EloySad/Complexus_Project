package com.riwi.complexus.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.List;

@Entity(name = "Advice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AdviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(nullable = false)
    private Boolean status;


    @ManyToOne
    @JoinColumn(name = "author_user_id")
    private long authorUser;


    @ManyToOne
    @JoinColumn(name = "author_admin_id")
    private long authorAdmin;


    @OneToMany(mappedBy = "advice", cascade = CascadeType.ALL)
    private List<MediaEntity> media;







}
