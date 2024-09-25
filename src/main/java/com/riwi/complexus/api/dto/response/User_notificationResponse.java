package com.riwi.complexus.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User_notificationResponse {
    private Boolean seen;
    private Long userId; 
    private Long notificationId; 
}
