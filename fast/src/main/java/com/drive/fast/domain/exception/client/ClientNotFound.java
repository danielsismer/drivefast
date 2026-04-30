package com.drive.fast.domain.exception.client;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(Long id){
        super("ID " + id + " not found!!!");
    }
}
