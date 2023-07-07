package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Repository.ProjectImagesRepository;
import com.InnovativeSolutions.project.Service.ProjectImagesService;
import org.modelmapper.ModelMapper;

public class ProjectImagesServiceImpl implements ProjectImagesService {

    private ProjectImagesRepository projectImagesRepository ;
    private ModelMapper modelMapper;

    public ProjectImagesServiceImpl(ProjectImagesRepository projectImagesRepository, ModelMapper modelMapper) {
        this.projectImagesRepository = projectImagesRepository;
        this.modelMapper = modelMapper;
    }


}
