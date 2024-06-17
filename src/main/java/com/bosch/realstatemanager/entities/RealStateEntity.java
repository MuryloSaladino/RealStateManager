package com.bosch.realstatemanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "RealStateEntity")
public class RealStateEntity extends BaseEntity {

    @Column(name = "sold")
    private Boolean sold = false;

    @Column(name = "price")
    private Float price;

    @Column(name = "size")
    private Integer size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_entity_id", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "real_state_category_entity_id", nullable = false)
    private RealStateCategoryEntity realStateCategory;


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

    public Integer getSize() { return size; }
    public void setSize(Integer size) {
        this.updateUpdatedAt();
        this.size = size;
    }

    public AddressEntity getAddress() { return address; }
    public void setAddress(AddressEntity address) {
        this.updateUpdatedAt();
        this.address = address;
    }

    public RealStateCategoryEntity getRealStateCategory() { return realStateCategory; }
    public void setRealStateCategory(RealStateCategoryEntity realStateCategory) {
        this.updateUpdatedAt();
        this.realStateCategory = realStateCategory;
    }

}
