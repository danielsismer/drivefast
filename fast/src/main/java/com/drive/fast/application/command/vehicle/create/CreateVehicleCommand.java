package com.drive.fast.application.command.vehicle.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateVehicleCommand(
        String marca,
        String modelo,
        String placa,
        BigDecimal valorDiaria
) {
}
