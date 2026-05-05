package com.drive.fast.api.handler.dto.request.lease;

import jakarta.validation.constraints.NotNull;

public record CreateLeaseRequest(
       @NotNull Integer dias,
       @NotNull Long client_id,
       @NotNull Long vehicle_id
) {
}
