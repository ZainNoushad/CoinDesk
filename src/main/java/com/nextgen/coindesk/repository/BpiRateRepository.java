package com.nextgen.coindesk.repository;

import com.nextgen.coindesk.model.BpiRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BpiRateRepository extends JpaRepository<BpiRate, Long> {
}
