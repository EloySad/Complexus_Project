package com.riwi.complexus.domain.entities;

import com.riwi.complexus.utils.enums.TypeCategory;
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
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(nullable = false)
    private Boolean status;


    @ManyToOne
    @JoinColumn(name = "author_resident_id")
    private long authorResident;


    @ManyToOne
    @JoinColumn(name = "author_admin_id")
    private long authorAdmin;


    @OneToMany(mappedBy = "advice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MediaEntity> media;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private CategoryEntity category;







}
