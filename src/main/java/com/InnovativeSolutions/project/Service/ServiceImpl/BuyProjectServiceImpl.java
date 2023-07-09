package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Exception.ResourceNotFoundException;
import com.InnovativeSolutions.project.Model.BuyProject;
import com.InnovativeSolutions.project.Payload.BuyProjectDTO;
import com.InnovativeSolutions.project.Repository.BuyProjectRepository;
import com.InnovativeSolutions.project.Service.BuyProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyProjectServiceImpl implements BuyProjectService {

    private BuyProjectRepository buyProjectRepository ;
    private ModelMapper modelMapper ;

    public BuyProjectServiceImpl(BuyProjectRepository buyProjectRepository, ModelMapper modelMapper) {
        this.buyProjectRepository = buyProjectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public BuyProjectDTO addproject(BuyProjectDTO buyProjectDTO) {

        BuyProject buyProject = modelMapper.map(buyProjectDTO,BuyProject.class);
        BuyProject saved= buyProjectRepository.save(buyProject);

        return modelMapper.map(saved, BuyProjectDTO.class);
    }

    @Override
    public List<BuyProjectDTO> getAllProjects() {

        if (buyProjectRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        List<BuyProject> getall = buyProjectRepository.findAll();

        return getall.stream().map(get->modelMapper.map(get,BuyProjectDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BuyProjectDTO getProjectById(Long projectId) {

        if (buyProjectRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("Project","id",projectId));

        return modelMapper.map(buyProject, BuyProjectDTO.class);
    }

    @Override
    public BuyProjectDTO updateproject(Long projectId, BuyProjectDTO buyProjectDTO) {

        if (buyProjectRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to update");
        }

        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()-> new ResourceNotFoundException("Project","id",projectId));

        buyProject.setLogoUrl(buyProjectDTO.getLogoUrl());
        buyProject.setName(buyProjectDTO.getName());
        buyProject.setDescription(buyProjectDTO.getDescription());
        buyProject.setCreatedBy(buyProjectDTO.getCreatedBy());
        buyProject.setFeatures(buyProjectDTO.getFeatures());
        buyProject.setTechnology(buyProjectDTO.getTechnology());
        buyProject.setSize(buyProjectDTO.getSize());
        buyProject.setCost(buyProjectDTO.getCost());
        buyProject.setPlatform(buyProjectDTO.getPlatform());
        buyProject.setDevPhone(buyProjectDTO.getDevPhone());
        buyProject.setDevWhatsApp(buyProjectDTO.getDevWhatsApp());
        buyProject.setDevWebsite(buyProjectDTO.getDevWebsite());
        buyProject.setEmail(buyProjectDTO.getEmail());

        BuyProject save = buyProjectRepository.save(buyProject);

        return modelMapper.map(save, BuyProjectDTO.class);
    }

    @Override
    public void deleteproject(Long projectId) {

        if (buyProjectRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to delete");
        }

        BuyProject buyProject = buyProjectRepository.findById(projectId)
                .orElseThrow(()-> new ResourceNotFoundException("Project","id",projectId));

        buyProjectRepository.delete(buyProject);

    }

    @Override
    public void deleteall() {

        if (buyProjectRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to delete");
        }
        buyProjectRepository.deleteAll();
    }
}
