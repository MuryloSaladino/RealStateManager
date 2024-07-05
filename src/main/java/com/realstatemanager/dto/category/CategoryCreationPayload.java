package com.realstatemanager.dto.category;


import com.realstatemanager.entities.CategoryEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CategoryCreationPayload {

    @NotEmpty(message = "You must provide a name")
    private String name;

    public CategoryEntity toCategory() {
        return new CategoryEntity(name);
    }
}
