package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Model.Category;
import com.InnovativeSolutions.project.Payload.CategoryDTO;
import com.InnovativeSolutions.project.Repository.CategoryRepository;
import com.InnovativeSolutions.project.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper ;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    // Add Category in the category table
    @Override
    public CategoryDTO addcategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO,Category.class);
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDTO.class);
    }
}
