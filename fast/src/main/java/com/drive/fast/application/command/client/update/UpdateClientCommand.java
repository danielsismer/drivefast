package com.drive.fast.application.command.client.update;

public record UpdateClientCommand(
        String nome,
        String email
) {
}
