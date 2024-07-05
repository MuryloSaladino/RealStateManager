package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;

public class CategoryResponse {

    public String name;

    public CategoryResponse(CategoryEntity category) {
        this.name = category.getName();
    }
}
