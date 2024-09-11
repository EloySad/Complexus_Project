package com.riwi.complexus.api.dto.request;

import java.time.LocalDateTime;

import com.riwi.complexus.utils.enums.TypeReaction;

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
public class ReactionRequest {
    private Long id; 
    private TypeReaction type;
    private LocalDateTime reactionDate;
}
