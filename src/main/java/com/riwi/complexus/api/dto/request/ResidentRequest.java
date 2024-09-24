package com.riwi.complexus.api.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRequest {

    @NotNull(message = "El numero de torre es obligatorio")
    private String tower;

    @NotNull(message = "El numero de residencia es obligatorio")
    private String residentialNumber;

    @NotNull private
    Boolean allowedNotification;

    @NotNull(message = "El ID de la unidad residencial es obligatorio")
    private Long userId;

}
