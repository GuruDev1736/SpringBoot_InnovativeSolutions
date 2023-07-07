package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Exception.ResourceNotFoundException;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<RealTimeDevelopmentDTO> getallRTD() {

        if (realTimeDevelopementRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        List<RealTimeDevelopment> realTimeDevelopmentList = realTimeDevelopementRepository.findAll();

        return realTimeDevelopmentList.stream().map((realTimeDevelopment -> mapper.map(realTimeDevelopment,RealTimeDevelopmentDTO.class))).collect(Collectors.toList());
    }

    @Override
    public RealTimeDevelopmentDTO getRtdById(Long RTDId) {

        if (realTimeDevelopementRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        RealTimeDevelopment realTimeDevelopment = realTimeDevelopementRepository.findById(RTDId)
                .orElseThrow(()->new ResourceNotFoundException("Realtime Development Project","id",RTDId));


        return mapper.map(realTimeDevelopment,RealTimeDevelopmentDTO.class);
    }

    @Override
    public void deleteall() {
        if (realTimeDevelopementRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }
        realTimeDevelopementRepository.deleteAll();
    }

    @Override
    public void deleteById(Long RTDId) {

        if (realTimeDevelopementRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        RealTimeDevelopment realTimeDevelopment = realTimeDevelopementRepository.findById(RTDId)
                .orElseThrow(()->new ResourceNotFoundException("Realtime Development Project","id",RTDId));

         realTimeDevelopementRepository.delete(realTimeDevelopment);
    }
}
