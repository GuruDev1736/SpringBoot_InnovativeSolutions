package com.InnovativeSolutions.project.Payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String name ;
    private String email;
    private String username;
    private String password;
    private String phone ;
    private String Address ;
    private String imageurl;

}
