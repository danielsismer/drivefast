package com.drive.fast.application.query.client.getall;

import com.drive.fast.api.handler.dto.response.client.ClientResponse;
import com.drive.fast.application.mapper.client.ClientMapper;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllClientsQueryHandler {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public List<ClientResponse> handle(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
