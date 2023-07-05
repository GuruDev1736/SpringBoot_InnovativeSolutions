package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Payload.CategoryDTO;
import com.InnovativeSolutions.project.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService ;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDTO> addcategory( @RequestBody CategoryDTO categoryDTO)
    {
        CategoryDTO add = categoryService.addcategory(categoryDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

}


