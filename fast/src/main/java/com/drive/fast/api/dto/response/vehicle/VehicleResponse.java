package com.drive.fast.api.dto.response.vehicle;

import java.math.BigDecimal;

public record VehicleResponse (
        Long id,
        String marca,
        String modelo,
        String placa,
        BigDecimal valorDiaria,
        boolean disponivel
){
}
