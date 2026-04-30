package com.drive.fast.application.mapper.client;

import com.drive.fast.api.dto.request.CreateClientRequest;
import com.drive.fast.api.dto.request.UpdateClientRequest;
import com.drive.fast.api.dto.response.ClientResponse;
import com.drive.fast.application.command.client.create.CreateClientCommand;
import com.drive.fast.application.command.client.update.UpdateClientCommand;
import com.drive.fast.domain.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public CreateClientCommand toCreateCommand(CreateClientRequest clientRequest){
        return new CreateClientCommand(
                clientRequest.nome(),
                clientRequest.cnh(),
                clientRequest.email()
        );
    }

    public UpdateClientCommand toUpdateCommand(UpdateClientRequest updateClientRequest){
        return new UpdateClientCommand(
                updateClientRequest.nome(),
                updateClientRequest.email()
        );
    }


    public ClientResponse toResponse(Client client){
        return new ClientResponse(
                client.getId(),
                client.getNome(),
                client.getCnh(),
                client.getEmail()
        );
    }
}
