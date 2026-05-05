package com.drive.fast.api.handler.dto.request.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateClientRequest(
        @NotBlank String nome,
        @NotBlank String cnh,
        @Email String email
) {
}
