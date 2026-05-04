package com.drive.fast.application.facade.vehicle.command.port;

import com.drive.fast.api.dto.request.vehicle.CreateVehicleRequest;
import com.drive.fast.api.dto.request.vehicle.UpdateVehicleRequest;
import com.drive.fast.api.dto.response.vehicle.VehicleResponse;

public interface VehicleCommandFacadePort {
    VehicleResponse create(CreateVehicleRequest createVehicleRequest);
    VehicleResponse update(Long id, UpdateVehicleRequest updateVehicleRequest);
    VehicleResponse delete(Long id);
}
