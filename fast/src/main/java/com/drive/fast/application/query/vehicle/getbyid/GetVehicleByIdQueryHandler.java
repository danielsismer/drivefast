package com.drive.fast.application.query.vehicle.getbyid;

import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.domain.exception.vehicle.VehicleNotFound;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetVehicleByIdQueryHandler {

    private final VehicleRepository repository;

    public Vehicle handle(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new VehicleNotFound(id));
    }

}
