package com.drive.fast.application.facade.vehicle.query.port;

import com.drive.fast.api.dto.response.vehicle.VehicleResponse;
import com.drive.fast.domain.entity.Vehicle;

import java.util.List;

public interface VehicleQueryFacadePort {
    VehicleResponse findById(Long id);
    List<VehicleResponse> findAll();
}
