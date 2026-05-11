package com.drive.fast.domain.exception.vehicle;

public class VehicleNotAvailable extends RuntimeException{
    public VehicleNotAvailable(Long id){
        super("The Vehicle " + id + " is already rented");
    }
}
