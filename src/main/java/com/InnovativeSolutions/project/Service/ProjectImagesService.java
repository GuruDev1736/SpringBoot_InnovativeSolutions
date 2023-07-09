package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Payload.ProjectImagesDTO;
import org.hibernate.dialect.LobMergeStrategy;

import java.util.List;

public interface ProjectImagesService {

    ProjectImagesDTO addimage( Long projectId , ProjectImagesDTO projectImagesDTO);
    List<ProjectImagesDTO> listimage (Long projectId);

    ProjectImagesDTO getimagebyid(Long projectId , Long imageId);
    void deleteimage (Long projectId , Long imageId);
    void deleteall (Long projectId);
}
