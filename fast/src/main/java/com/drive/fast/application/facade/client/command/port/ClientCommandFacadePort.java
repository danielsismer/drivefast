package com.drive.fast.application.facade.client.command.port;

import com.drive.fast.api.dto.request.CreateClientRequest;
import com.drive.fast.api.dto.request.UpdateClientRequest;
import com.drive.fast.api.dto.response.ClientResponse;

public interface ClientCommandFacadePort {
    ClientResponse create(CreateClientRequest request);
    ClientResponse update(Long id, UpdateClientRequest request);
    ClientResponse delete(Long id);
}
