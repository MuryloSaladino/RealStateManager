package com.realstatemanager.interfaces;

import com.realstatemanager.dto.category.CategoryCreation;
import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryCreation category);
    List<CategoryEntity> readAll();
    List<RealStateEntity> readByCategory(Long id);
}
