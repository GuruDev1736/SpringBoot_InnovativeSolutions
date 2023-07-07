package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Model.RealTimeDevelopment;
import com.InnovativeSolutions.project.Payload.RealTimeDevelopmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealTimeDevelopementService {

    RealTimeDevelopmentDTO addRTD ( RealTimeDevelopmentDTO realTimeDevelopmentDTO);
    List<RealTimeDevelopmentDTO> getallRTD();

    RealTimeDevelopmentDTO getRtdById(Long RTDId);

    void deleteall();

    void deleteById (Long RTDId);

}
