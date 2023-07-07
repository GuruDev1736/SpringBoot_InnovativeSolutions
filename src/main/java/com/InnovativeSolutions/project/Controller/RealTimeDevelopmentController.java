package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Model.RealTimeDevelopment;
import com.InnovativeSolutions.project.Payload.RealTimeDevelopmentDTO;
import com.InnovativeSolutions.project.Repository.RealTimeDevelopementRepository;
import com.InnovativeSolutions.project.Service.RealTimeDevelopementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<RealTimeDevelopmentDTO>> getallRTD()
    {
      return new ResponseEntity<>(realTimeDevelopementService.getallRTD(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealTimeDevelopmentDTO> getRTDById(@PathVariable(name = "id") Long RTDId)
    {
        return new ResponseEntity<>(realTimeDevelopementService.getRtdById(RTDId),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid (@PathVariable(name = "id") Long RTDId)
    {
        realTimeDevelopementService.deleteById(RTDId);
        return new ResponseEntity<>("The Realtime Developement Project with id "+RTDId+" has Deleted",HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteall ()
    {
        realTimeDevelopementService.deleteall();
        return new ResponseEntity<>("All Real Time Development has deleted",HttpStatus.OK);
    }

}
