package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "RealStateEntity")
public class RealStateEntity extends BaseEntity {

    @Column(name = "sold")
    private Boolean sold = false;

    @Column(name = "price")
    private Float price;

    @Column(name = "squaredMeters")
    private Integer squaredMeters;

    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deletedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressEntityId", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "realStateCategoryEntityId", nullable = false)
    private CategoryEntity realStateCategory;

    @OneToMany(mappedBy = "realStateEntity")
    private Set<ScheduleEntity> realStateEntities;


    public Boolean getSold() { return sold; }
    public void setSold(Boolean sold) {
        this.updateUpdatedAt();
        this.sold = sold;
    }

    public Float getPrice() { return price; }
    public void setPrice(Float price) {
        this.updateUpdatedAt();
        this.price = price;
    }

    public Integer getSize() { return squaredMeters; }
    public void setSize(Integer squaredMeters) {
        this.updateUpdatedAt();
        this.squaredMeters = squaredMeters;
    }

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Timestamp deletedAt) {
        this.updateUpdatedAt();
        this.deletedAt = deletedAt;
    }

    public AddressEntity getAddress() { return address; }
    public void setAddress(AddressEntity address) {
        this.updateUpdatedAt();
        this.address = address;
    }

    public CategoryEntity getRealStateCategory() { return realStateCategory; }
    public void setRealStateCategory(CategoryEntity realStateCategory) {
        this.updateUpdatedAt();
        this.realStateCategory = realStateCategory;
    }

    public Set<ScheduleEntity> getScheduleEntities() { return realStateEntities; }
}
