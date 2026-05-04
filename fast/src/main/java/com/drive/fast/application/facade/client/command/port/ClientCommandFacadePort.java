package com.drive.fast.application.facade.client.command.port;

import com.drive.fast.api.dto.request.client.CreateClientRequest;
import com.drive.fast.api.dto.request.client.UpdateClientRequest;
import com.drive.fast.api.dto.response.client.ClientResponse;

public interface ClientCommandFacadePort {
    ClientResponse create(CreateClientRequest request);
    ClientResponse update(Long id, UpdateClientRequest request);
    ClientResponse delete(Long id);
}
