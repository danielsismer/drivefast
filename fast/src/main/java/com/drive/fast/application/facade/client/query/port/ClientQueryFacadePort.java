package com.drive.fast.application.facade.client.query.port;

import com.drive.fast.api.handler.dto.response.client.ClientResponse;

import java.util.List;

public interface ClientQueryFacadePort {
    ClientResponse getById(Long id);
    List<ClientResponse> list();
}
