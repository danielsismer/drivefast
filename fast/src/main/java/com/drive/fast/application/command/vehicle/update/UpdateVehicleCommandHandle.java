package com.drive.fast.application.command.vehicle.update;

import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.domain.exception.vehicle.VehicleNotFound;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateVehicleCommandHandle {

    private final VehicleRepository repository;

    public Vehicle handle(Long id, UpdateVehicleCommand command){

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new VehicleNotFound(id));

        vehicle.setValorDiaria(command.valorDiaria());

        return repository.save(vehicle);

    }
}
