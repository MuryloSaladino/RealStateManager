package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class CategoryCreation {

    @NotEmpty
    private String name;

    public CategoryEntity toCategory() {
        return new CategoryEntity(name);
    }
}
