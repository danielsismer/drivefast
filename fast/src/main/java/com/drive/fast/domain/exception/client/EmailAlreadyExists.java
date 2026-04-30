package com.drive.fast.domain.exception.client;

public class EmailAlreadyExists extends RuntimeException{
    public EmailAlreadyExists(String email){
        super(email + "already exists, please, try again!");
    }
}
