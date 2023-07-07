package com.InnovativeSolutions.project.Payload;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyProjectDTO {

    private Long id ;
    private String logoUrl;
    private String name;
    private String createdBy;
    private Set<ProjectImagesDTO> projectImages;
    private String description;
    private String features;
    private String technology;
    private Long size;
    private Long cost;
    private String platform;
    private Long devPhone;
    private Long devWhatsApp;
    private String devWebsite;
    @Email
    private String email;

}
