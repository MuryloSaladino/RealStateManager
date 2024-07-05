package com.realstatemanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter @Entity @Table(name = "RealStateEntity")
public class RealStateEntity extends BaseEntity {

    @Column(name = "sold")
    private Boolean sold = false;

    @Column(name = "price")
    private Float price;

    @Column(name = "squaredMeters")
    private Integer squaredMeters;

    @Setter
    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressEntityId", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "categoryEntityId", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "realStateEntity")
    private Set<ScheduleEntity> realStateEntities;


    public RealStateEntity() {}

    public RealStateEntity(Boolean sold, Float price, Integer squaredMeters, AddressEntity address) {
        super();
        this.sold = sold;
        this.price = price;
        this.squaredMeters = squaredMeters;
        this.address = address;
    }


    public void setSold(Boolean sold) {
        this.updateUpdatedAt();
        this.sold = sold;
    }

    public void setPrice(Float price) {
        this.updateUpdatedAt();
        this.price = price;
    }

    public void setSize(Integer squaredMeters) {
        this.updateUpdatedAt();
        this.squaredMeters = squaredMeters;
    }

    public void setAddress(AddressEntity address) {
        this.updateUpdatedAt();
        this.address = address;
    }

    public void setCategory(CategoryEntity realStateCategory) {
        this.updateUpdatedAt();
        this.category = realStateCategory;
    }
}
