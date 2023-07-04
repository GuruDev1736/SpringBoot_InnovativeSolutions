package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Payload.LoginDTO;
import com.InnovativeSolutions.project.Payload.RegisterDTO;
import org.springframework.stereotype.Service;



public interface LoginService {
    String login(LoginDTO loginDTO);

    String register(RegisterDTO registerDTO);
}
