package com.drive.fast.api.handler.dto.response.client;

public record ClientResponse(
        Long id,
        String nome,
        String cnh,
        String email
) {
}
