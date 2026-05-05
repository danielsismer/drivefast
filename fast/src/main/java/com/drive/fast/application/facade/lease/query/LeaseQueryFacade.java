package com.drive.fast.application.facade.lease.query;

import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;
import com.drive.fast.application.facade.lease.query.port.LeaseQueryFacadePort;
import com.drive.fast.application.mapper.lease.LeaseMapper;
import com.drive.fast.application.query.lease.getall.GetAllLeasesQueryHandler;
import com.drive.fast.application.query.lease.getbyid.GetLeaseByIdQueryHandler;
import com.drive.fast.domain.entity.Lease;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaseQueryFacade implements LeaseQueryFacadePort {

    private final LeaseMapper mapper;
    private final GetAllLeasesQueryHandler getAll;
    private final GetLeaseByIdQueryHandler getById;

    @Override
    public List<LeaseResponse> findAll() {
        return getAll.handle()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public LeaseResponse findById(Long id) {
        return mapper.toResponse(getById.handle(id));
    }
}
