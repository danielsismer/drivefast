package com.drive.fast.application.command.lease.create;

public record CreateLeaseCommand(
        Integer dias,
        Long client_id,
        Long vehicle_id
) {
}
