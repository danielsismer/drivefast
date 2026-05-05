package com.drive.fast.application.command.lease.delete;

import com.drive.fast.domain.entity.Lease;
import com.drive.fast.domain.exception.lease.LeaseNotFound;
import com.drive.fast.infrastructure.persistence.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLeaseCommandHandler {

    private final LeaseRepository repository;

    public Lease handle(Long id){

        Lease lease = repository.findById(id)
                .orElseThrow(() -> new LeaseNotFound(id));

        repository.delete(lease);

        return lease;
    }
}
