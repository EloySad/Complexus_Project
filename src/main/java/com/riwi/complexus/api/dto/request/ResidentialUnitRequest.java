package com.riwi.complexus.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResidentialUnitRequest {

        @NotNull(message = "El nombre es obligatorio")
        private String name;

        @NotNull(message = "La ciudad es obligatoria")
        private String city;

        @NotNull(message = "La dirección es obligatoria")
        private String adress;

        @NotBlank(message = "El ID del usuario es obligatorio")
        private Long userId;
}
