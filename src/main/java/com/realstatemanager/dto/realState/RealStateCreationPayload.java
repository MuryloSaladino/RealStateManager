package com.realstatemanager.dto.realState;

import com.realstatemanager.entities.RealStateEntity;
import com.realstatemanager.interfaces.EntityCreationPayload;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class RealStateCreationPayload implements EntityCreationPayload<RealStateEntity> {

    private Float price;

    private Integer squaredMeters;


    @Override
    public RealStateEntity toEntity() {
        return null;
    }
}
