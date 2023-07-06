package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Payload.CategoryDTO;
import com.InnovativeSolutions.project.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getallcategory()
    {
        return new ResponseEntity<>(categoryService.getallCategorty(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getcategorybyid(@PathVariable(name = "id") Long category_id)
    {
        CategoryDTO categoryDTO = categoryService.getcategorybyid(category_id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletecategorybyid(@PathVariable(name = "id") Long category_id)
    {
        categoryService.deletecategorybyid(category_id);
        return new ResponseEntity<>("The following category with id :"+category_id+" has deleted",HttpStatus.OK);
    }

    @DeleteMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteall ()
    {
        categoryService.deleteall();
        return new ResponseEntity<>("All Categories has been deleted",HttpStatus.OK);
    }



}


