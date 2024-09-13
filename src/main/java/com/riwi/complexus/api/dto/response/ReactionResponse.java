package com.riwi.complexus.api.dto.response;

import java.time.LocalDateTime;

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
public class ReactionResponse {
    private Long id;
    private Boolean liked;
    private LocalDateTime createdAt;
    private Long postId; 
    private Long userId; 
}
