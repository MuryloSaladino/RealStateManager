package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table(name = "RealStateCategoryEntity")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "category")
    private Set<RealStateEntity> realStateEntities;


    public CategoryEntity() {}

    public CategoryEntity(String name) {
        super();
        this.name = name;
    }


    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }
}
