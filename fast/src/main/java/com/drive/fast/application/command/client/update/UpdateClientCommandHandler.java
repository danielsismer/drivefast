package com.drive.fast.application.command.client.update;

import com.drive.fast.api.dto.response.ClientResponse;
import com.drive.fast.application.mapper.client.ClientMapper;
import com.drive.fast.domain.entity.Client;
import com.drive.fast.domain.exception.client.ClientNotFound;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClientCommandHandler {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientResponse handle(Long id, UpdateClientCommand command){

        Client client = repository.findById(id)
                .orElseThrow(() -> new ClientNotFound(id));

        client.setNome(command.nome());
        client.setEmail(command.email());

        return mapper.toResponse(repository.save(client));

    }
}
