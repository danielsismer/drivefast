package com.drive.fast.api.dto.request.vehicle;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateVehicleRequest(
        @NotNull BigDecimal valorDiaria
){
}
