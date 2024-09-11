package com.riwi.complexus.api.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdviceResponse {
    private String title;
    private String description;
    private Boolean status;
    private LocalDateTime createDate;
    private Long authorResidentId;
    private Long authorAdminId;
    private Long categoryId;
    private Long mediaId;
    private List<String> mediaUrls;

}
