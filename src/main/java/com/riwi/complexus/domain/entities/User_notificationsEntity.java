package com.riwi.complexus.domain.entities;

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

@Entity(name = "user_notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_notificationsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean seen;

    // Relación Many-to-One con la entidad UserEntity. Un usuario puede tener muchas notificaciones.
    // Se especifica que este campo está relacionado con la columna "user_id" en la base de datos.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Relación Many-to-One con la entidad NotificationsEntity. Una notificación puede estar asociada a muchos usuarios.
    // Se especifica que este campo está relacionado con la columna "notification_id" en la base de datos.
    @ManyToOne
    @JoinColumn(name = "notification_id")
    private NotificationsEntity notification; 
}
