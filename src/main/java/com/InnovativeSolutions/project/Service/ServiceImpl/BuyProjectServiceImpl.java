package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Repository.BuyProjectRepository;
import com.InnovativeSolutions.project.Service.BuyProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BuyProjectServiceImpl implements BuyProjectService {

    private BuyProjectRepository buyProjectRepository ;
    private ModelMapper modelMapper ;

    public BuyProjectServiceImpl(BuyProjectRepository buyProjectRepository, ModelMapper modelMapper) {
        this.buyProjectRepository = buyProjectRepository;
        this.modelMapper = modelMapper;
    }


}
