package com.drive.fast.application.mapper.lease;

import com.drive.fast.api.handler.dto.request.lease.CreateLeaseRequest;
import com.drive.fast.api.handler.dto.request.lease.UpdateLeaseRequest;
import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;
import com.drive.fast.application.command.lease.create.CreateLeaseCommand;
import com.drive.fast.application.command.lease.update.UpdateLeaseCommand;
import com.drive.fast.domain.entity.Lease;
import org.springframework.stereotype.Component;

@Component
public class LeaseMapper {

    public LeaseResponse toResponse(Lease lease){
        return new LeaseResponse(
                lease.getId(),
                lease.getDias(),
                lease.getValorTotal(),
                lease.getCliente() != null ? lease.getCliente().getId() : null,
                lease.getVeiculo() != null ? lease.getVeiculo().getId() : null
        );
    }

    public CreateLeaseCommand toCreateCommand(CreateLeaseRequest request){
        return new CreateLeaseCommand(
                request.dias(),
                request.client_id(),
                request.vehicle_id()
        );
    }

    public UpdateLeaseCommand toUpdateCommand(UpdateLeaseRequest request){
        return new UpdateLeaseCommand(
                request.dias(),
                request.client_id(),
                request.vehicle_id()
        );
    }

}
