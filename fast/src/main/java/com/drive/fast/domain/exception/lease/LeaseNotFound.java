package com.drive.fast.domain.exception.lease;

public class LeaseNotFound extends RuntimeException {
    public LeaseNotFound(Long id) {
        super("Lease with ID " + id + " not found!!!");
    }
}
