package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Exception.ResourceNotFoundException;
import com.InnovativeSolutions.project.Model.BuyProject;
import com.InnovativeSolutions.project.Model.ProjectImages;
import com.InnovativeSolutions.project.Payload.ProjectImagesDTO;
import com.InnovativeSolutions.project.Repository.BuyProjectRepository;
import com.InnovativeSolutions.project.Repository.ProjectImagesRepository;
import com.InnovativeSolutions.project.Service.ProjectImagesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectImagesServiceImpl implements ProjectImagesService {

    private ProjectImagesRepository projectImagesRepository ;
    private BuyProjectRepository buyProjectRepository ;
    private ModelMapper modelMapper;

    public ProjectImagesServiceImpl(ProjectImagesRepository projectImagesRepository, BuyProjectRepository buyProjectRepository, ModelMapper modelMapper) {
        this.projectImagesRepository = projectImagesRepository;
        this.buyProjectRepository = buyProjectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectImagesDTO addimage(Long projectId, ProjectImagesDTO projectImagesDTO) {

        if (projectImagesRepository.existsByImageUrl(projectImagesDTO.getImageUrl()))
        {
            throw new ApplicationException(HttpStatus.BAD_REQUEST,"Image Already Exist");
        }

        ProjectImages projectImages = modelMapper.map(projectImagesDTO,ProjectImages.class);
        BuyProject checkid = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project","id",projectId));

        projectImages.setBuyProject(checkid);
        ProjectImages save = projectImagesRepository.save(projectImages);


        return modelMapper.map(save,ProjectImagesDTO.class);
    }

    @Override
    public List<ProjectImagesDTO> listimage(Long projectId) {


        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project","id",projectId));

       List<ProjectImages> list = projectImagesRepository.findByBuyProjectId(projectId);

        return list.stream().map((imagelist)->modelMapper.map(imagelist,ProjectImagesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProjectImagesDTO getimagebyid(Long projectId , Long imageId) {

        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project","id",projectId));
        ProjectImages projectImages = projectImagesRepository.findById(imageId)
                .orElseThrow(()->new ResourceNotFoundException("Images","id",imageId));

        if (!projectImages.getBuyProject().getId().equals(buyProject.getId()))
        {
            throw new ApplicationException(HttpStatus.BAD_REQUEST,"Image Not Found for the following project");
        }

        return modelMapper.map(projectImages,ProjectImagesDTO.class);
    }

    @Override
    public void deleteimage(Long projectId, Long imageId) {

        BuyProject buyProject = buyProjectRepository.findById(projectId).orElseThrow(()->new ResourceNotFoundException("project","id",projectId));
        ProjectImages projectImages = projectImagesRepository.findById(imageId)
                .orElseThrow(()->new ResourceNotFoundException("images","id",imageId));

        if (!projectImages.getBuyProject().getId().equals(buyProject.getId()))
        {
            throw new ApplicationException(HttpStatus.BAD_REQUEST,"Image Not Found for the following project");
        }

        projectImagesRepository.delete(projectImages);

    }

    @Override
    public void deleteall(Long projectId) {
        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("project","id",projectId));
        List<ProjectImages> list = projectImagesRepository.findByBuyProjectId(projectId);
        projectImagesRepository.deleteAll(list);
    }
}
