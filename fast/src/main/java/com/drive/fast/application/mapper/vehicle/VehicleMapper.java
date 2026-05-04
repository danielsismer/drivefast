package com.drive.fast.application.mapper.vehicle;

import com.drive.fast.api.dto.request.vehicle.CreateVehicleRequest;
import com.drive.fast.api.dto.request.vehicle.UpdateVehicleRequest;
import com.drive.fast.api.dto.response.vehicle.VehicleResponse;
import com.drive.fast.application.command.vehicle.create.CreateVehicleCommand;
import com.drive.fast.application.command.vehicle.update.UpdateVehicleCommand;
import com.drive.fast.domain.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {


    public CreateVehicleCommand toCreateCommand(CreateVehicleRequest request) {
        return new CreateVehicleCommand(
                request.marca(),
                request.modelo(),
                request.placa(),
                request.valorDiaria()
        );
    }

    public UpdateVehicleCommand toUpdateCommand(UpdateVehicleRequest request) {
        return new UpdateVehicleCommand(
                request.valorDiaria()
        );
    }

    public VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getMarca(),
                vehicle.getModelo(),
                vehicle.getPlaca(),
                vehicle.getValorDiaria(),
                vehicle.isDisponivel()
        );
    }
}
