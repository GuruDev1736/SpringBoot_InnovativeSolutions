package com.InnovativeSolutions.project.Payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectReviewsDTO {

    private Long id ;
    private String email;
    private String feedback;

}
