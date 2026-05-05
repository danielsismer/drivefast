package com.drive.fast.application.facade.vehicle.command;

import com.drive.fast.api.handler.dto.request.vehicle.CreateVehicleRequest;
import com.drive.fast.api.handler.dto.request.vehicle.UpdateVehicleRequest;
import com.drive.fast.api.handler.dto.response.vehicle.VehicleResponse;
import com.drive.fast.application.command.vehicle.create.CreateVehicleCommandHandle;
import com.drive.fast.application.command.vehicle.delete.DeleteVehicleCommandHandle;
import com.drive.fast.application.command.vehicle.update.UpdateVehicleCommandHandle;
import com.drive.fast.application.facade.vehicle.command.port.VehicleCommandFacadePort;
import com.drive.fast.application.mapper.vehicle.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleCommandFacade implements VehicleCommandFacadePort {

    private final VehicleMapper mapper;
    private final CreateVehicleCommandHandle create;
    private final UpdateVehicleCommandHandle update;
    private final DeleteVehicleCommandHandle delete;

    @Override
    public VehicleResponse create(CreateVehicleRequest createVehicleRequest) {
        return mapper.toResponse(create.handle(mapper.toCreateCommand(createVehicleRequest)));
    }

    @Override
    public VehicleResponse update(Long id, UpdateVehicleRequest updateVehicleRequest) {
        return mapper.toResponse(update.handle(id, mapper.toUpdateCommand(updateVehicleRequest)));
    }

    @Override
    public VehicleResponse delete(Long id) {
        return mapper.toResponse(delete.handle(id));
    }
}
