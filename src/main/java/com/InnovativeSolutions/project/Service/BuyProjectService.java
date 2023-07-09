package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Payload.BuyProjectDTO;

import java.util.List;

public interface BuyProjectService {

    BuyProjectDTO addproject (BuyProjectDTO buyProjectDTO);

    List<BuyProjectDTO> getAllProjects();
    BuyProjectDTO getProjectById (Long projectId );

    BuyProjectDTO updateproject (Long projectId , BuyProjectDTO buyProjectDTO);

    void deleteproject(Long projectId);
    void deleteall();

}
