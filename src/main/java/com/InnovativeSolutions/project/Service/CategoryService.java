package com.InnovativeSolutions.project.Service;

import com.InnovativeSolutions.project.Model.Category;
import com.InnovativeSolutions.project.Payload.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addcategory (CategoryDTO categoryDTO);
    List<CategoryDTO> getallCategorty();

    CategoryDTO getcategorybyid (Long categoryid);

    CategoryDTO updatecategoy(CategoryDTO categoryDTO , Long categoryId);

    void deletecategorybyid(Long categoryid);

    void deleteall();
}
