package com.drive.fast.application.command.lease.update;

public record UpdateLeaseCommand (
        Integer dias,
        Long client_id,
        Long vehicle_id
){
}
