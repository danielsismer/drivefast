package com.drive.fast.application.facade.client.command;

import com.drive.fast.api.handler.dto.request.client.CreateClientRequest;
import com.drive.fast.api.handler.dto.request.client.UpdateClientRequest;
import com.drive.fast.api.handler.dto.response.client.ClientResponse;
import com.drive.fast.application.command.client.create.CreateClientCommandHandler;
import com.drive.fast.application.command.client.delete.DeleteClientCommandHandler;
import com.drive.fast.application.command.client.update.UpdateClientCommandHandler;
import com.drive.fast.application.facade.client.command.port.ClientCommandFacadePort;
import com.drive.fast.application.mapper.client.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCommandFacade implements ClientCommandFacadePort {

    private final CreateClientCommandHandler create;
    private final UpdateClientCommandHandler update;
    private final DeleteClientCommandHandler delete;
    private final ClientMapper mapper;

    @Override
    public ClientResponse create(CreateClientRequest request) {
        return create.handle(mapper.toCreateCommand(request));
    }

    @Override
    public ClientResponse update(Long id, UpdateClientRequest request) {
        return update.handle(id, mapper.toUpdateCommand(request));
    }

    @Override
    public ClientResponse delete(Long id) {
        return delete.handle(id);
    }
}
