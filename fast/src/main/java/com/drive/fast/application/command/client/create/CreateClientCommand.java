package com.drive.fast.application.command.client.create;

public record CreateClientCommand(
        String nome,
        String cnh,
        String email
) {
}
