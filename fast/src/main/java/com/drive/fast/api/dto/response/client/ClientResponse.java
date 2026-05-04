package com.drive.fast.api.dto.response.client;

public record ClientResponse(
        Long id,
        String nome,
        String cnh,
        String email
) {
}
