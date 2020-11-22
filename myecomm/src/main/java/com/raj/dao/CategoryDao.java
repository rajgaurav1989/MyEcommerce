package com.raj.dao;

import com.raj.entities.CategoryDO;
import com.raj.models.CategoryDTO;
import com.raj.repositories.CategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryDao {

    @Autowired private CategoryRepository categoryRepository;


    public void addCategory(CategoryDTO categoryDTO){
        CategoryDO categoryDO = getCategoryDO(categoryDTO);
        categoryRepository.save(categoryDO);
    }

    public List<CategoryDO> getAllCategories(){
        return categoryRepository.findAll();
    }

    public CategoryDO getCategoryById(String categoryId){
        return categoryRepository.findById(UUID.fromString(categoryId)).get();
    }

    public void updateCategory(CategoryDTO categoryDTO) {
        CategoryDO oldCategory = categoryRepository.findById(UUID.fromString(categoryDTO.getId())).get();
        getCategoryDO(categoryDTO);
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(String categoryId){
        List<CategoryDO> categoryDOs = categoryRepository.findAllChildAndParent(UUID.fromString(categoryId));
        categoryRepository.deleteAll(categoryDOs);
    }

    private CategoryDO getCategoryDO(CategoryDTO categoryDTO){
        CategoryDO categoryDO = new CategoryDO();

        if (StringUtils.isNotBlank(categoryDTO.getId()))
            categoryDO.setId(UUID.fromString(categoryDTO.getId()));
        categoryDO.setName(categoryDTO.getName());
        categoryDO.setDescription(categoryDTO.getDescription());

        if (StringUtils.isNotBlank(categoryDTO.getParentId())){
            categoryDO.setParentId(UUID.fromString(categoryDTO.getParentId()));
        }

        return categoryDO;
    }
}
