package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Exception.ResourceNotFoundException;
import com.InnovativeSolutions.project.Model.BuyProject;
import com.InnovativeSolutions.project.Model.ProjectReviews;
import com.InnovativeSolutions.project.Payload.ProjectImagesDTO;
import com.InnovativeSolutions.project.Payload.ProjectReviewsDTO;
import com.InnovativeSolutions.project.Repository.BuyProjectRepository;
import com.InnovativeSolutions.project.Repository.ProjectReviewRepository;
import com.InnovativeSolutions.project.Service.ProjectReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectReviewServiceImpl implements ProjectReviewService {

    private ModelMapper modelMapper;
    private BuyProjectRepository buyProjectRepository ;
    private ProjectReviewRepository projectReviewRepository ;

    public ProjectReviewServiceImpl(ModelMapper modelMapper, BuyProjectRepository buyProjectRepository, ProjectReviewRepository projectReviewRepository) {
        this.modelMapper = modelMapper;
        this.buyProjectRepository = buyProjectRepository;
        this.projectReviewRepository = projectReviewRepository;
    }

    @Override
    public ProjectReviewsDTO addreview(Long projectId, ProjectReviewsDTO projectReviewsDTO) {

        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project" , "id",projectId));

        ProjectReviews projectReviews = modelMapper.map(projectReviewsDTO,ProjectReviews.class);
        projectReviews.setReview(buyProject);
        ProjectReviews save = projectReviewRepository.save(projectReviews);

        return modelMapper.map(save,ProjectReviewsDTO.class) ;
    }

    @Override
    public List<ProjectReviewsDTO> getall(Long projectId) {

        BuyProject check = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project","id",projectId));

        List<ProjectReviews> list = projectReviewRepository.findByReviewId(projectId);

        return list.stream().map((getall)->modelMapper.map(getall,ProjectReviewsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProjectReviewsDTO getbyid(Long projectId, Long reviewId) {

        BuyProject check = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("project","id",projectId));

        ProjectReviews projectReviews = projectReviewRepository.findById(reviewId)
                .orElseThrow(()->new ResourceNotFoundException("Reviews","id",reviewId));

       if (!projectReviews.getReview().getId().equals(check.getId()))
       {
           throw new ApplicationException(HttpStatus.BAD_REQUEST,"Review not found or the following project");
       }

        return modelMapper.map(projectReviews, ProjectReviewsDTO.class) ;
    }
}
