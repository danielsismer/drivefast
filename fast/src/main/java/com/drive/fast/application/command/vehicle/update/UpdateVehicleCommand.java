package com.drive.fast.application.command.vehicle.update;

import java.math.BigDecimal;

public record UpdateVehicleCommand(
        BigDecimal valorDiaria
) {
}
