package com.bosch.realstatemanager.repositories;

import com.bosch.realstatemanager.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateCategoryRepository extends JpaRepository<CategoryEntity, Long> { }
