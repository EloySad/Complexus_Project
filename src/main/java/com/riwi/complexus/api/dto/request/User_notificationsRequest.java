package com.riwi.complexus.api.dto.request;

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
public class User_notificationsRequest {
    private Boolean seen; 
    private Boolean archived; 
    
}
