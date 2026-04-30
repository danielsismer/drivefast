package com.drive.fast.application.facade.client.query;

import com.drive.fast.api.dto.response.ClientResponse;
import com.drive.fast.application.facade.client.query.port.ClientQueryFacadePort;
import com.drive.fast.application.mapper.client.ClientMapper;
import com.drive.fast.application.query.getall.GetAllClientsQueryHandler;
import com.drive.fast.application.query.getbyid.GetClientByIdQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientQueryFacade implements ClientQueryFacadePort {

    private final ClientMapper mapper;
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
