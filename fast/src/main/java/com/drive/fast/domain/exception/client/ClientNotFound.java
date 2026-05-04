package com.drive.fast.domain.exception.client;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(Long id){
        super("Client with ID " + id + " not found!!!");
    }
}
