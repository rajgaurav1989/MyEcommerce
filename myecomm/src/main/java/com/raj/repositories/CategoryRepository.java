package com.raj.repositories;

import com.raj.entities.CategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryDO, UUID> {

    @Query("from CategoryDO where id = ?1 or parentId = ?1")
    public List<CategoryDO> findAllChildAndParent(UUID categoryId);
}
