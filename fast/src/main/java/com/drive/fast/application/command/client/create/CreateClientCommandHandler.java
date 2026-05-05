package com.drive.fast.application.command.client.create;


import com.drive.fast.api.handler.dto.response.client.ClientResponse;
import com.drive.fast.application.mapper.client.ClientMapper;
import com.drive.fast.domain.entity.Client;
import com.drive.fast.domain.exception.client.EmailAlreadyExists;
import com.drive.fast.infrastructure.persistence.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClientCommandHandler {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientResponse handle(CreateClientCommand command){

        if (repository.existsByEmail(command.email())){
            throw new EmailAlreadyExists(command.email());
        }

        Client client = Client.create(
                command.nome(),
                command.cnh(),
                command.email()
        );

        return mapper.toResponse(repository.save(client));

    }

}
