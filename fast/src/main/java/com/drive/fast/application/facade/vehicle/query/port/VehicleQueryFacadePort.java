package com.drive.fast.application.facade.vehicle.query.port;

import com.drive.fast.api.handler.dto.response.vehicle.VehicleResponse;

import java.util.List;

public interface VehicleQueryFacadePort {
    VehicleResponse findById(Long id);
    List<VehicleResponse> findAll();
}
