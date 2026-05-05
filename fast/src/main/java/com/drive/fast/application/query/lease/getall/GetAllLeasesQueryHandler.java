package com.drive.fast.application.query.lease.getall;

import com.drive.fast.domain.entity.Lease;
import com.drive.fast.infrastructure.persistence.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllLeasesQueryHandler {

    private final LeaseRepository repository;

    public List<Lease> handle(){
        return repository.findAll();
    }

}
