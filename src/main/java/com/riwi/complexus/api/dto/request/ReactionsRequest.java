package com.riwi.complexus.api.dto.request;

import java.time.LocalDateTime;

import com.riwi.complexus.domain.entities.PostEntity;
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
    private Long postId;
    private Long UserId;
}
