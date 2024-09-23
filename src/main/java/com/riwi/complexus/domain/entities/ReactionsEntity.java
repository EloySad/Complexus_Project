package com.riwi.complexus.domain.entities;

import java.time.LocalDateTime;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReactionsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean liked; 

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Relación Many-to-One con la entidad PostEntity. Una reacción puede estar asociada opcionalmente a un post.
    // Se especifica el nombre de la columna de la clave foránea como "post_id".
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    // Relación Many-to-One con la entidad UserEntity. Una reación puede estar asociada opcionalmente a un usuario.
    // Se especifica el nombre de la columna de la clave foránea como "user_id".
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; 
}
