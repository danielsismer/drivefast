package com.drive.fast.application.facade.client.query.port;

import com.drive.fast.api.dto.response.ClientResponse;

import java.util.List;

public interface ClientQueryFacadePort {
    ClientResponse getById(Long id);
    List<ClientResponse> list();
}
