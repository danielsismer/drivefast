package com.drive.fast.application.facade.client.query;

import com.drive.fast.api.handler.dto.response.client.ClientResponse;
import com.drive.fast.application.facade.client.query.port.ClientQueryFacadePort;
import com.drive.fast.application.query.client.getall.GetAllClientsQueryHandler;
import com.drive.fast.application.query.client.getbyid.GetClientByIdQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientQueryFacade implements ClientQueryFacadePort {

    private final GetAllClientsQueryHandler getAll;
    private final GetClientByIdQueryHandler getById;

    @Override
    public ClientResponse getById(Long id) {
        return getById.handle(id);
    }

    @Override
    public List<ClientResponse> list() {
        return getAll.handle();
    }
}
