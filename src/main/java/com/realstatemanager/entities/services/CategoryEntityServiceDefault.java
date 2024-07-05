package com.realstatemanager.entities.services;

import com.realstatemanager.dto.category.CategoryCreation;
import com.realstatemanager.entities.CategoryEntity;
import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.exceptions.NotFoundException;
import com.realstatemanager.interfaces.CategoryService;
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
    RealStateRepository realStateRepository;


    @Override
    public CategoryEntity create(CategoryCreation payload) {
        return categoryRepository.save(payload.toCategory());
    }

    @Override
    public List<CategoryEntity> readAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public List<RealStateEntity> readByCategory(Long id) {

        var query = categoryRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return realStateRepository.findByCategory(query.get());
    }
}
