package com.riwi.complexus.api.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private Integer tower;
    private Integer apto;
}
