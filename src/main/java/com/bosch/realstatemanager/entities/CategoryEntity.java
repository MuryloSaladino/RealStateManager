package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table(name = "RealStateCategoryEntity")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "realStateCategory")
    private Set<RealStateEntity> realStateEntities;


    public CategoryEntity() {}

    public CategoryEntity(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }
}
