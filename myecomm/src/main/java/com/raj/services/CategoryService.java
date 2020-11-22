package com.raj.services;

import com.raj.dao.CategoryDao;
import com.raj.entities.CategoryDO;
import com.raj.models.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired private CategoryDao categoryDao;

    public List<CategoryDTO> getAllCategories(){
        return categoryDao.getAllCategories().stream().map(e -> getCategoryDTO(e)).collect(Collectors.toList());
    }

    public void addCategory(CategoryDTO categoryDTO){
        categoryDao.addCategory(categoryDTO);
    }

    public void deleteCategory(String categoryId){
        categoryDao.deleteCategory(categoryId);
    }

    public CategoryDTO getById(String categoryId){
        return getCategoryDTO(categoryDao.getCategoryById(categoryId));
    }

    public void updateCategory(CategoryDTO categoryDTO){
        categoryDao.updateCategory(categoryDTO);
    }

    private CategoryDTO getCategoryDTO(CategoryDO categoryDO){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(categoryDO.getId().toString());
        categoryDTO.setName(categoryDO.getName());
        categoryDTO.setDescription(categoryDO.getDescription());
        categoryDTO.setParentId(categoryDO.getParentId().toString());

        return categoryDTO;
    }

}
