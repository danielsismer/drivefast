package com.drive.fast.infrastructure.persistence;

import com.drive.fast.domain.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
}
