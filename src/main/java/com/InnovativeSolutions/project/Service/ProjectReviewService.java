package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Model.ProjectImages;
import com.InnovativeSolutions.project.Payload.ProjectImagesDTO;
import com.InnovativeSolutions.project.Payload.ProjectReviewsDTO;

import java.util.List;

public interface ProjectReviewService {

    ProjectReviewsDTO addreview( Long projectId , ProjectReviewsDTO projectReviewsDTO);
    List<ProjectReviewsDTO> getall (Long projectId);

    ProjectReviewsDTO getbyid(Long projectId , Long reviewId);



}
