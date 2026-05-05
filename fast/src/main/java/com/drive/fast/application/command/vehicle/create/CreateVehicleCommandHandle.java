package com.drive.fast.application.command.vehicle.create;

import com.drive.fast.application.mapper.vehicle.VehicleMapper;
import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateVehicleCommandHandle {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public Vehicle handle(CreateVehicleCommand command) {

        // add verifications here

        Vehicle vehicle = Vehicle.create(
                command.marca(),
                command.modelo(),
                command.placa(),
                command.valorDiaria()
        );

        return repository.save(vehicle);
    }
}
