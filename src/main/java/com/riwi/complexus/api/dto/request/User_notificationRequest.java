package com.riwi.complexus.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User_notificationRequest {
    
    private Boolean seen;
    private Long userId; 
    private Long notificationId; 
}
