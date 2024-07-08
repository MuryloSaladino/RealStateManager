package com.realstatemanager.services;

import com.realstatemanager.dto.category.CategoryCreationPayload;
import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.interfaces.CategoryService;
import com.realstatemanager.interfaces.RealStateService;
import com.realstatemanager.repositories.CategoryRepository;
import com.realstatemanager.repositories.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryEntityServiceDefault implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RealStateService realStateService;


    @Override
    public CategoryEntity create(CategoryCreationPayload payload) {
        return categoryRepository.save(payload.toEntity());
    }

    @Override
    public List<CategoryEntity> readAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }
}
