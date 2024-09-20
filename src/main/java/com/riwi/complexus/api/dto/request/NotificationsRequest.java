package com.riwi.complexus.api.dto.request;

import java.time.LocalDateTime;

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
    private Long postId;
    private Long userId;
}
