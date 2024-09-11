package com.riwi.complexus.api.dto.response;

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
public class ReactionResponse {
    private Long id;
    private TypeReaction type;
    private LocalDateTime reactionDate;
    private Long residentId;
    private Long adminId;
    private Long adviceId; 
}
