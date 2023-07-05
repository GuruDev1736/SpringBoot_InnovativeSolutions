package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Model.RealTimeDevelopment;
import com.InnovativeSolutions.project.Payload.RealTimeDevelopmentDTO;
import com.InnovativeSolutions.project.Repository.RealTimeDevelopementRepository;
import com.InnovativeSolutions.project.Service.RealTimeDevelopementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RTD")
public class RealTimeDevelopmentController {

    private RealTimeDevelopementService realTimeDevelopementService ;

    public RealTimeDevelopmentController(RealTimeDevelopementService realTimeDevelopementService) {
        this.realTimeDevelopementService = realTimeDevelopementService;
    }

    @PostMapping("/add")
    public ResponseEntity<RealTimeDevelopmentDTO> addRTD ( @RequestBody RealTimeDevelopmentDTO realTimeDevelopmentDTO)
    {
        RealTimeDevelopmentDTO realTimeDevelopment = realTimeDevelopementService.addRTD(realTimeDevelopmentDTO);
        return new ResponseEntity<>(realTimeDevelopment, HttpStatus.CREATED);
    }

}
