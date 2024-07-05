package com.realstatemanager.interfaces;

import com.realstatemanager.dto.realState.RealStateCreationPayload;
import com.realstatemanager.entities.RealStateEntity;

import java.util.List;

public interface RealStateService {
    RealStateService create(RealStateCreationPayload payload);
    List<RealStateEntity> readAll();
}
