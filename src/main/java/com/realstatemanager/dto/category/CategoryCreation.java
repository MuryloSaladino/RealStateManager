package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;

public class CategoryCreation {

    private String name;

    public CategoryEntity toCategory() {
        return new CategoryEntity();
    }
}
