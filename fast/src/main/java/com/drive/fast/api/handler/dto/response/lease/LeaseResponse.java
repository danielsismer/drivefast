package com.drive.fast.api.handler.dto.response.lease;

import java.math.BigDecimal;

public record LeaseResponse (
        Long id,
        Integer dias,
        BigDecimal valotTotal,
        Long client_id,
        Long vehicle_id
){
}
