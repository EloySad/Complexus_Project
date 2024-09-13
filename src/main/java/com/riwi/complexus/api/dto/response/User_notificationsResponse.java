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
public class User_notificationsResponse {
    private Long id; 
    private Boolean seen;
    private Boolean archived; 
    private Long userId;
    private Long notificationId; 
}
