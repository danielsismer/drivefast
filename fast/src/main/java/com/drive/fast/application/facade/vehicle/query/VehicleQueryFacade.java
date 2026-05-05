package com.drive.fast.application.facade.vehicle.query;

import com.drive.fast.api.handler.dto.response.vehicle.VehicleResponse;
import com.drive.fast.application.facade.vehicle.query.port.VehicleQueryFacadePort;
import com.drive.fast.application.mapper.vehicle.VehicleMapper;
import com.drive.fast.application.query.vehicle.getall.GetAllVehiclesQueryHandler;
import com.drive.fast.application.query.vehicle.getbyid.GetVehicleByIdQueryHandler;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleQueryFacade implements VehicleQueryFacadePort {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;
    private final GetAllVehiclesQueryHandler getAll;
    private final GetVehicleByIdQueryHandler getById;

    @Override
    public VehicleResponse findById(Long id) {
        return mapper.toResponse(getById.handle(id));
    }

    @Override
    public List<VehicleResponse> findAll() {
        return getAll.handle()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
