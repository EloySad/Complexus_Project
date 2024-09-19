package com.riwi.complexus.api.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationsRequest {
    
    private String message; 
    private LocalDateTime createdAt;
    private Long adminId;
    private List<Long> residentId;
}
