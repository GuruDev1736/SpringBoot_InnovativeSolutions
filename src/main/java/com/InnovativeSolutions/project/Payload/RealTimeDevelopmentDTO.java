package com.InnovativeSolutions.project.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RealTimeDevelopmentDTO
 * 
 */

 @Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
public class RealTimeDevelopmentDTO {

     private Long development_id;
    private String topic ;
    private String requirement ;
    private Long phone ;
    private Long whatsappNo ;
    private Long budget ;
    private Long category_id ;
    private String email ;


}
