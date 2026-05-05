package com.drive.fast.application.facade.lease.command;

import com.drive.fast.api.handler.dto.request.lease.CreateLeaseRequest;
import com.drive.fast.api.handler.dto.request.lease.UpdateLeaseRequest;
import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;
import com.drive.fast.application.command.lease.create.CreateLeaseCommandHandler;
import com.drive.fast.application.command.lease.delete.DeleteLeaseCommandHandler;
import com.drive.fast.application.command.lease.update.UpdateLeaseCommandHandler;
import com.drive.fast.application.facade.lease.command.port.LeaseCommandFacadePort;
import com.drive.fast.application.mapper.lease.LeaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseCommandFacade implements LeaseCommandFacadePort {

    private final LeaseMapper mapper;
    private final CreateLeaseCommandHandler create;
    private final UpdateLeaseCommandHandler update;
    private final DeleteLeaseCommandHandler delete;

    @Override
    public LeaseResponse save(CreateLeaseRequest request) {
        return mapper.toResponse(create.handle(mapper.toCreateCommand(request)));
    }

    @Override
    public LeaseResponse update(Long id, UpdateLeaseRequest request) {
        return mapper.toResponse(update.handle(id, mapper.toUpdateCommand(request)));
    }

    @Override
    public LeaseResponse delete(Long id) {
        return mapper.toResponse(delete.handle(id));
    }
}
