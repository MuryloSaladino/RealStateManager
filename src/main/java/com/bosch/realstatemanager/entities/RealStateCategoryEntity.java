package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "RealStateCategoryEntity")
public class RealStateCategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "category")
    private Set<RealStateEntity> realStateEntities;


    public String getName() { return name; }
    public void setName(String name) {
        this.updateUpdatedAt();
        this.name = name;
    }

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }
}
