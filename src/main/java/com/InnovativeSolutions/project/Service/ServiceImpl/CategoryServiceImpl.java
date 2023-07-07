package com.InnovativeSolutions.project.Service.ServiceImpl;

import com.InnovativeSolutions.project.Exception.ApplicationException;
import com.InnovativeSolutions.project.Exception.ResourceNotFoundException;
import com.InnovativeSolutions.project.Model.Category;
import com.InnovativeSolutions.project.Payload.CategoryDTO;
import com.InnovativeSolutions.project.Repository.CategoryRepository;
import com.InnovativeSolutions.project.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (categoryRepository.existsByName(categoryDTO.getName()))
        {
            throw new ApplicationException(HttpStatus.BAD_REQUEST,"Category Already Exist");
        }
        Category category = modelMapper.map(categoryDTO,Category.class);
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getallCategorty() {

        if (categoryRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Category is Empty");
        }

        List<Category> category  = categoryRepository.findAll();
        return category.stream().map(category1 -> modelMapper.map(category1,CategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getcategorybyid(Long categoryid) {

        if (categoryRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to get");
        }

        Category category = categoryRepository.findById(categoryid)
                .orElseThrow(()->new ResourceNotFoundException("Category","id",categoryid));



        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updatecategoy(CategoryDTO categoryDTO, Long categoryId) {

        if (categoryRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to update");
        }
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
       Category updated = categoryRepository.save(category);

        return modelMapper.map(updated,CategoryDTO.class);
    }


    @Override
    public void deletecategorybyid(Long categoryid) {

        Category category =categoryRepository.findById(categoryid)
                .orElseThrow(()->new ResourceNotFoundException("Category","id",categoryid));

        categoryRepository.delete(category);
    }

    @Override
    public void deleteall() {

        if (categoryRepository.count()==0)
        {
            throw new ApplicationException(HttpStatus.OK,"Nothing to delete");
        }
        categoryRepository.deleteAll();
    }
}
