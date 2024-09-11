package com.riwi.complexus.api.dto.response;

import com.riwi.complexus.utils.enums.RolsAdmin;
import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {

        private Long id;

        private String name;

        private String lastname;

        private String email;

        private String phone;

        private RolsAdmin role;
}
