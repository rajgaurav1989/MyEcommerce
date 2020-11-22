package com.raj.controllers;

import com.raj.models.CategoryDTO;
import com.raj.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired private CategoryService categoryService;


    @GetMapping(value = "")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/id/{categoryId}")
    public CategoryDTO getById(@PathVariable(value = "categoryId") String categoryId){
        return categoryService.getById(categoryId);
    }

    @PostMapping(value = "")
    public void addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCategory(categoryDTO);
    }

    @PutMapping(value = "")
    public void updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping(value = "/id/{categoryId}")
    public void deleteCategory(@PathVariable(value = "categoryId") String categoryId){
        categoryService.deleteCategory(categoryId);
    }

}
