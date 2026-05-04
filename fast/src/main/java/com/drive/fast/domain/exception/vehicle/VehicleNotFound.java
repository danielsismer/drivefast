package com.drive.fast.domain.exception.vehicle;

public class VehicleNotFound extends RuntimeException{
    public VehicleNotFound(Long id){
        super("Vehicle with ID " + id + " not found!!!");
    }
}
