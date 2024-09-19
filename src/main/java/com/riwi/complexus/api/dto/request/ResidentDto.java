package com.riwi.complexus.api.dto.request;

import com.riwi.complexus.domain.entities.ResidentialUnitEntity;
import com.riwi.complexus.domain.entities.RolsEntity;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentDto {
    @NotBlank
    @Max(100)
    private String name;

    @NotBlank
    @Max(100)
    private String lastname;

    @NotBlank
    @Email(message = "The field needs to be a valid email")
    private String email;

    // Regex reference: https://regexr.com/3bfsi
    @NotBlank
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Invalid password")
    private String password;

    @NotBlank
    @Max(40)
    private String phone;

    @NotBlank
    private RolsEntity role;

    @Max(100)
    private String tower;

    @NotBlank
    @Max(100)
    private String residentialNumber;

    @NotBlank
    private ResidentialUnitEntity residentialUnitId;

}
