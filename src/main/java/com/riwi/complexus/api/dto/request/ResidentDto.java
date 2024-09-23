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

    private String name;

    private  String username;

    private String lastname;

    private String email;

    // Regex reference: https://regexr.com/3bfsi

    private String password;

    private String phone;

    private Long roleId;

    private String tower;

    private String residentialNumber;

    private Long residentialUnitId;

}
