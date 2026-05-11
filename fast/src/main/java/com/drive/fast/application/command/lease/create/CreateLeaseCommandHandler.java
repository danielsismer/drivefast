package com.drive.fast.application.command.lease.create;

import com.drive.fast.domain.entity.Client;
import com.drive.fast.domain.entity.Lease;
import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.domain.exception.client.ClientNotFound;
import com.drive.fast.domain.exception.vehicle.VehicleNotAvailable;
import com.drive.fast.domain.exception.vehicle.VehicleNotFound;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import com.drive.fast.infrastructure.persistence.LeaseRepository;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLeaseCommandHandler {

    private final LeaseRepository leaseRepository;
    private final ClientRepository clientRepository;
    private final VehicleRepository vehicleRepository;

    public Lease handle(CreateLeaseCommand command) {

        Client client = clientRepository.findById(command.client_id())
                .orElseThrow(() -> new ClientNotFound(command.client_id()));

        Vehicle vehicle = vehicleRepository.findById(command.vehicle_id())
                .orElseThrow(() -> new VehicleNotFound(command.vehicle_id()));

        if (!vehicle.isDisponivel()) {
            throw new VehicleNotAvailable(command.vehicle_id());
        }

        Lease lease = Lease.create(command.dias(), client, vehicle);

        return leaseRepository.save(lease);
    }
}
