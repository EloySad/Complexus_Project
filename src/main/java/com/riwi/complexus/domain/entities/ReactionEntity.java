package com.riwi.complexus.domain.entities;

import java.time.LocalDateTime;

import com.riwi.complexus.utils.enums.TypeReaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "reactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeReaction type;

    @Column(nullable = false)
    private LocalDateTime reaccionDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AdminEntity admin;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AdviceEntity advice;
}
