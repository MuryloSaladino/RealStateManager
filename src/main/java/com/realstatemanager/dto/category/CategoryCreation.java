package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;
import lombok.Getter;

@Getter
public class CategoryCreation {

    private String name;

    public CategoryEntity toCategory() {
        return new CategoryEntity();
    }
}
