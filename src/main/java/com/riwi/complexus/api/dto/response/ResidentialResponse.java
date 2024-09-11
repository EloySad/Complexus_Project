package com.riwi.complexus.api.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentialResponse {
    private Long id;
    private String name;
    private String city;
    private String address;
    private Boolean hasTower;
}
