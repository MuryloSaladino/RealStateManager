package com.bosch.realstatemanager.dto.realStateCategory;

import com.bosch.realstatemanager.entities.CategoryEntity;

public class CategoryCreation {

    private String name;

    public CategoryEntity toCategory() {
        return new CategoryEntity();
    }
}
