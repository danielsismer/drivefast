package com.drive.fast.application.facade.lease.command.port;

import com.drive.fast.api.handler.dto.request.lease.CreateLeaseRequest;
import com.drive.fast.api.handler.dto.request.lease.UpdateLeaseRequest;
import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;

public interface LeaseCommandFacadePort {
    LeaseResponse save(CreateLeaseRequest request);
    LeaseResponse update(Long id, UpdateLeaseRequest request);
    LeaseResponse delete(Long id);
}
