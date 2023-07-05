package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Model.Category;
import com.InnovativeSolutions.project.Model.RealTimeDevelopment;
import com.InnovativeSolutions.project.Model.User;
import com.InnovativeSolutions.project.Repository.CategoryRepository;
import com.InnovativeSolutions.project.Repository.UserRepository;
import org.modelmapper.ModelMapper;

import com.InnovativeSolutions.project.Payload.RealTimeDevelopmentDTO;
import com.InnovativeSolutions.project.Repository.RealTimeDevelopementRepository;
import com.InnovativeSolutions.project.Service.RealTimeDevelopementService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class RealTimeDevelopmentImpl implements RealTimeDevelopementService {

    private ModelMapper mapper;
    private RealTimeDevelopementRepository realTimeDevelopementRepository;
    private UserRepository userRepository ;

    private CategoryRepository categoryRepository ;

    public RealTimeDevelopmentImpl(ModelMapper mapper, RealTimeDevelopementRepository realTimeDevelopementRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.realTimeDevelopementRepository = realTimeDevelopementRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public RealTimeDevelopmentDTO addRTD(RealTimeDevelopmentDTO realTimeDevelopmentDTO) {

        if (userRepository.existsByEmail(realTimeDevelopmentDTO.getEmail()))
        {
            if (realTimeDevelopementRepository.existsByTopicAndEmail(realTimeDevelopmentDTO.getTopic(), realTimeDevelopmentDTO.getEmail()))
            {
                throw new ApplicationException(HttpStatus.BAD_REQUEST,"Topic is Already Registered with the same email");
            }
            else
            {

            Category category = categoryRepository.findById(realTimeDevelopmentDTO.getCategory_id()).orElseThrow(() -> new ApplicationException(HttpStatus.BAD_REQUEST,"Invalid CategoryID"));
            RealTimeDevelopment realTimeDevelopment = mapper.map(realTimeDevelopmentDTO,RealTimeDevelopment.class);
            realTimeDevelopment.setCategory(category);
            RealTimeDevelopment save = realTimeDevelopementRepository.save(realTimeDevelopment);
            return mapper.map(save,RealTimeDevelopmentDTO.class);
            }

        }
        else
        {
            throw new ApplicationException(HttpStatus.BAD_REQUEST,"Please Enter the Registerd Email ");
        }

    }
}
