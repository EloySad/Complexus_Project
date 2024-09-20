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
public class ReactionsRequest {
    
    private Boolean liked; 
    private LocalDateTime createdAt; 
}
