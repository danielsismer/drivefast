package com.drive.fast.application.command.lease.update;

import com.drive.fast.domain.entity.Client;
import com.drive.fast.domain.entity.Lease;
import com.drive.fast.domain.entity.Vehicle;
import com.drive.fast.domain.exception.client.ClientNotFound;
import com.drive.fast.domain.exception.lease.LeaseNotFound;
import com.drive.fast.domain.exception.vehicle.VehicleNotFound;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import com.drive.fast.infrastructure.persistence.LeaseRepository;
import com.drive.fast.infrastructure.persistence.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLeaseCommandHandler {

    private final LeaseRepository leaseRepository;
    private final ClientRepository clientRepository;
    private final VehicleRepository vehicleRepository;

    public Lease handle(Long id, UpdateLeaseCommand command) {
        Lease lease = leaseRepository.findById(id)
                .orElseThrow(() -> new LeaseNotFound(id));

        Client client = command.client_id() != null
                ? clientRepository.findById(command.client_id())
                .orElseThrow(() -> new ClientNotFound(command.client_id()))
                : null;

        Vehicle vehicle = command.vehicle_id() != null
                ? vehicleRepository.findById(command.vehicle_id())
                .orElseThrow(() -> new VehicleNotFound(command.vehicle_id()))
                : null;

        lease.update(command.dias(), client, vehicle);

        return leaseRepository.save(lease);
    }

}
