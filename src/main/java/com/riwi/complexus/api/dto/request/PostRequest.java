package com.riwi.complexus.api.dto.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String description;
    private boolean pinned;
    private LocalDateTime createdAt;
    private Long userId;
    private List<MediaRequest> media;


}
