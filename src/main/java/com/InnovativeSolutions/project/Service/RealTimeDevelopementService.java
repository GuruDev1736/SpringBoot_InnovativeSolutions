package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Model.RealTimeDevelopment;
import com.InnovativeSolutions.project.Payload.RealTimeDevelopmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealTimeDevelopementService {

    RealTimeDevelopmentDTO addRTD ( RealTimeDevelopmentDTO realTimeDevelopmentDTO);


}
