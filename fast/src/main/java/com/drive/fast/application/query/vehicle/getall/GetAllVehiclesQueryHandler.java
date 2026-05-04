package com.drive.fast.application.query.vehicle.getall;

import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllVehiclesQueryHandler {

    private final VehicleRepository repository;

    public List<Vehicle> handle(){
        return repository.findAll()
                .stream()
                .toList();
    }
}
