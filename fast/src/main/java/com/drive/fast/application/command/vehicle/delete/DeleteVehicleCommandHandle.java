package com.drive.fast.application.command.vehicle.delete;

import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.domain.exception.vehicle.VehicleNotFound;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteVehicleCommandHandle {

    private final VehicleRepository repository;

    public Vehicle handle(Long id){

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new VehicleNotFound(id));

        repository.delete(vehicle);

        return vehicle;
    }
}
