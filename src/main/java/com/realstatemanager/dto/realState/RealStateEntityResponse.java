package com.realstatemanager.dto.realState;

import com.realstatemanager.dto.address.AddressEntityResponse;
import com.realstatemanager.entities.RealStateEntity;

public class RealStateEntityResponse {

    public Boolean sold;
    public Float price;
    public Integer squaredMeters;
    public AddressEntityResponse address;
    public String category;

    public RealStateEntityResponse(RealStateEntity realStateEntity) {
        this.sold = realStateEntity.getSold();
        this.price = realStateEntity.getPrice();
        this.squaredMeters = realStateEntity.getSquaredMeters();
        this.address = new AddressEntityResponse(realStateEntity.getAddress());
        this.category = realStateEntity.getCategory().getName();
    }
}
