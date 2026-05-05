package com.drive.fast.application.facade.lease.query.port;

import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;

import java.util.List;

public interface LeaseQueryFacadePort {
    List<LeaseResponse> findAll();
    LeaseResponse findById(Long id);
}
