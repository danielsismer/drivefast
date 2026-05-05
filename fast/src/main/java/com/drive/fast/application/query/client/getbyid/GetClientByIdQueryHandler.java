package com.drive.fast.application.query.client.getbyid;

import com.drive.fast.api.handler.dto.response.client.ClientResponse;
import com.drive.fast.application.mapper.client.ClientMapper;
import com.drive.fast.domain.exception.client.ClientNotFound;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetClientByIdQueryHandler {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientResponse handle(Long id){
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ClientNotFound(id));
    }

}
