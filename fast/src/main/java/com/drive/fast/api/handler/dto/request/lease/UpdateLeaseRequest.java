package com.drive.fast.api.handler.dto.request.lease;

public record UpdateLeaseRequest(
        Integer dias,
        Long client_id,
        Long vehicle_id
) {
}
