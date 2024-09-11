package com.riwi.complexus.api.dto.request;

import lombok.*;




@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdviceRequest {
    private String title;
    private String description;
    private Boolean status;
    private Long authorResidentId;
    private Long authorAdminId;
    private Long categoryId;
    private Long mediaId;
}
