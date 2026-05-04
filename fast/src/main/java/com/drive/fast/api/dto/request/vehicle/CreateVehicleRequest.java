package com.drive.fast.api.dto.request.vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateVehicleRequest(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa,
        @NotNull BigDecimal valorDiaria
) {
}
