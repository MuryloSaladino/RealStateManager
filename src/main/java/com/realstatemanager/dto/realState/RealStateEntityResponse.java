package com.realstatemanager.dto.realState;


import com.realstatemanager.entities.RealStateEntity;

public class RealStateEntityResponse {

    public Boolean sold;
    public Float price;
    public Integer squaredMeters;

    public RealStateEntityResponse(RealStateEntity realStateEntity) {
        this.sold = realStateEntity.getSold();
        this.price = realStateEntity.getPrice();
        this.squaredMeters = realStateEntity.getSquaredMeters();
    }
}
