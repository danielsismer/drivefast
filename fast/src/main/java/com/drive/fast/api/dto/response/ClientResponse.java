package com.drive.fast.api.dto.response;

public record ClientResponse(
        Long id,
        String nome,
        String cnh,
        String email
) {
}
