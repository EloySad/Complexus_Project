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

        @NotNull(message = "name cannot be null and void")
        private String name;

        @NotNull(message = "city cannot be null and void")
        private String city;

        @NotNull(message = "adress cannot be null and void")
        private String adress;

        @NotBlank(message = "id user cannot be null and void")
        private Long userId;
}
