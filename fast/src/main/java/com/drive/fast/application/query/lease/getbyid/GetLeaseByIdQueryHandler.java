package com.drive.fast.application.query.lease.getbyid;

import com.drive.fast.domain.entity.Lease;
import com.drive.fast.domain.exception.lease.LeaseNotFound;
import com.drive.fast.infrastructure.persistence.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetLeaseByIdQueryHandler {

    private final LeaseRepository repository;

    public Lease handle(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new LeaseNotFound(id));
    }

}
