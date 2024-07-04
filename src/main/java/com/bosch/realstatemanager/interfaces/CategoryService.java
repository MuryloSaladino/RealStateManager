package com.bosch.realstatemanager.interfaces;

import com.bosch.realstatemanager.dto.realStateCategory.CategoryCreation;
import com.bosch.realstatemanager.entities.CategoryEntity;
import com.bosch.realstatemanager.entities.RealStateEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryCreation category);
    List<CategoryEntity> readAll();
    List<RealStateEntity> readByCategory(Long id);
}
