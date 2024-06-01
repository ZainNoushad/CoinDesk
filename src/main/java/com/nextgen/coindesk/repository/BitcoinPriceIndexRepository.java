package com.nextgen.coindesk.repository;

import com.nextgen.coindesk.model.BitcoinPriceIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinPriceIndexRepository extends JpaRepository<BitcoinPriceIndex, Long> {
}
