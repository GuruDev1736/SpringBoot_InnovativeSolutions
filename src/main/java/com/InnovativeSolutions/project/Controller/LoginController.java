package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Payload.JWTAuthResponse;
import com.InnovativeSolutions.project.Payload.LoginDTO;
import com.InnovativeSolutions.project.Payload.RegisterDTO;
import com.InnovativeSolutions.project.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private LoginService loginService ;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDTO)
    {
        String token  = loginService.login(loginDTO);
        JWTAuthResponse jwtAuthReponse = new JWTAuthResponse();

        jwtAuthReponse.setAccessToken(token);
        jwtAuthReponse.setUsername(loginDTO.getUsernameOrEmail());
        jwtAuthReponse.setMessage("Login Successful");
        return ResponseEntity.ok(jwtAuthReponse);


    }


    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterDTO registerDTO)
    {
        String response = loginService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
